package com.example.leo.testapp.app.album

import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import com.example.leo.testapp.R
import com.example.leo.testapp.adapter.AlbumAdapter
import com.example.leo.testapp.architecture.BaseActivity
import com.example.leo.testapp.config.TestAppComponent
import kotlinx.android.synthetic.main.activity_album.*
import java.util.ArrayList

class AlbumActivity : BaseActivity<AlbumPresenter>(), AlbumView {
    private val ALBUM_SAVE_INSTANCE = "ALBUMSAVEINSTANCE"
    private val RECYCLER_SAVE_INSTANCE = "RECYCLERSAVEINSTANCE"
    private lateinit var mAdapter: AlbumAdapter
    private var mRcvSaveInstance: Parcelable? = null
    private var mAlbums: List<String>? = null


    override fun injectActivity(component: TestAppComponent) = component.inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        if (savedInstanceState == null) {
            mPresenter.getAlbum()
        }
    }

    override fun onResume() {
        super.onResume()
        if (mRcvSaveInstance != null) {
            showAlbum(mAlbums as List)
            album_activity_rcv_album.layoutManager.onRestoreInstanceState(mRcvSaveInstance)
        }
    }

    override fun showAlbum(albums: List<String>) {
        mAlbums = albums
        mAdapter = AlbumAdapter(albums)
        album_activity_rcv_album.layoutManager = LinearLayoutManager(this)
        album_activity_rcv_album.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putStringArrayList(ALBUM_SAVE_INSTANCE, mAlbums as ArrayList<String>)
        mRcvSaveInstance = album_activity_rcv_album.layoutManager.onSaveInstanceState()
        outState?.putParcelable(RECYCLER_SAVE_INSTANCE, mRcvSaveInstance)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            mRcvSaveInstance = savedInstanceState.getParcelable(RECYCLER_SAVE_INSTANCE)
            mAlbums = savedInstanceState.getStringArrayList(ALBUM_SAVE_INSTANCE)
        }

    }
}
