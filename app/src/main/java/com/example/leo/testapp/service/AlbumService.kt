package com.example.leo.testapp.service

import com.example.leo.testapp.model.Album
import io.reactivex.Observable
import retrofit2.http.GET

interface AlbumService {

    @GET("albums")
    fun getAlbums(): Observable<List<Album>>
}