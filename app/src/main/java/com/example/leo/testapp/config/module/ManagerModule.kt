package com.example.leo.testapp.config.module

import com.example.leo.testapp.manager.AlbumManager
import com.example.leo.testapp.manager.impl.AlbumManagerImpl
import com.example.leo.testapp.service.AlbumService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ManagerModule {

    @Provides
    @Singleton
    fun provideAlbumManager(albumService: AlbumService): AlbumManager = AlbumManagerImpl(albumService)
}