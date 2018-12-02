package com.example.leo.testapp.config.module


import com.example.leo.testapp.app.album.AlbumPresenter
import com.example.leo.testapp.manager.AlbumManager
import dagger.Module
import dagger.Provides


@Module
class PresenterModule {

    @Provides
    fun provideAlbumPresenter(albumManager: AlbumManager) = AlbumPresenter(albumManager)

}