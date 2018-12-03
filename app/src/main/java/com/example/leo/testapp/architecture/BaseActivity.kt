package com.example.leo.testapp.architecture

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.leo.testapp.config.TestAppApplication
import com.example.leo.testapp.config.TestAppComponent
import javax.inject.Inject


abstract class BaseActivity<P : BasePresenter<*>> : AppCompatActivity(), BaseView {

    @Inject
    lateinit var mPresenter: P

    private var TAG: String?
        get() = this::class.simpleName
        set(value) = Unit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            injectActivity(TestAppApplication.component)
        } catch (e: Throwable) {
            Log.w(TAG, "${TestAppApplication::class.simpleName} could not injected => Method injectFragment(component: ${TestAppApplication::class.simpleName}) not implemented", e)
        }
        mPresenter.onViewAttach(this)
        lifecycle.addObserver(mPresenter)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(mPresenter)
    }

    abstract fun injectActivity(component: TestAppComponent)

}
