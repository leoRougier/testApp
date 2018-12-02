package com.example.leo.testapp.app.album

import android.os.Bundle
import com.example.leo.testapp.R
import com.example.leo.testapp.architecture.BaseActivity
import com.example.leo.testapp.config.TestAppComponent

class AlbumActivity : BaseActivity<AlbumPresenter>(), AlbumView {

    override fun injectActivity(component: TestAppComponent) = component.inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        mPresenter.getAlbum()
    }


}