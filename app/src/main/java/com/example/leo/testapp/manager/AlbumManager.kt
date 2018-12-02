package com.example.leo.testapp.manager

import com.example.leo.testapp.model.Album
import io.reactivex.Observable

interface AlbumManager {

    fun getAlbums(): Observable<List<Album>>
}