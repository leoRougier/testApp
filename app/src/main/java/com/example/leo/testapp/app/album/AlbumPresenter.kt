package com.example.leo.testapp.app.album

import android.util.Log
import com.example.leo.testapp.architecture.BasePresenter
import com.example.leo.testapp.manager.AlbumManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AlbumPresenter(private val albumManager: AlbumManager): BasePresenter<AlbumView>() {
    fun getAlbum() {
        albumManager.getAlbums()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { lifecycleDisposable(it) }
            .subscribe({
               Log.i("ALBUMLIST", it.toString())
            })
    }
}