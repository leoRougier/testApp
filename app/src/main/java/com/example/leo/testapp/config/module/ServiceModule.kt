package com.example.leo.testapp.config.module

import com.example.leo.testapp.service.AlbumService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideServicePlayer(@Named(ApiModule.API_RETROFIT) retrofit: Retrofit): AlbumService =
        retrofit.create<AlbumService>(AlbumService::class.java)

}