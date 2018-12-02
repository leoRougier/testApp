package com.example.leo.testapp.config
import ccom.example.leo.testapp.config.module.TestAppModule
import com.example.leo.testapp.app.album.AlbumActivity
import com.example.leo.testapp.config.module.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        ApiModule::class,
        TestAppModule::class,
        PresenterModule::class,
        ManagerModule::class,
        ServiceModule::class
))
interface TestAppComponent {

        fun inject(o: TestAppApplication)
        fun inject(o: AlbumActivity)

}