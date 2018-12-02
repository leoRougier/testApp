package ccom.example.leo.testapp.config.module
import android.content.Context
import android.content.SharedPreferences
import com.example.leo.testapp.BuildConfig.APPLICATION_ID
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides

import org.greenrobot.eventbus.EventBus

import javax.inject.Singleton

@Module
class TestAppModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences(APPLICATION_ID.plus("_preferences"), Context.MODE_PRIVATE)


    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()


    }
