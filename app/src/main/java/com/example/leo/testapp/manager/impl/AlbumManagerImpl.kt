package com.example.leo.testapp.manager.impl

import com.example.leo.testapp.manager.AlbumManager
import com.example.leo.testapp.model.Album
import com.example.leo.testapp.service.AlbumService
import io.reactivex.Observable

class AlbumManagerImpl(private val albumService: AlbumService) : AlbumManager {
    override fun getAlbums(): Observable<List<Album>> = albumService.getAlbums()
}