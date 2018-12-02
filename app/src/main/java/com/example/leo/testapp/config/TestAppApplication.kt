package com.example.leo.testapp.config
import android.app.Application
import com.example.leo.testapp.config.module.ApplicationModule

open class TestAppApplication: Application() {

    companion object {
        @JvmStatic
        lateinit var component: TestAppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerTestAppComponent.builder().applicationModule(ApplicationModule(this)).build()
        component.inject(this)

    }

}