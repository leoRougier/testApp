package com.example.leo.testapp.app.album

import com.example.leo.testapp.architecture.BaseView
import com.example.leo.testapp.model.Album

interface AlbumView: BaseView {
    fun showAlbum(albums: List<String>)
}