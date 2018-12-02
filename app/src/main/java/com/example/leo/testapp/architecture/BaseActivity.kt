package com.example.leo.testapp.architecture

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.leo.testapp.config.TestAppApplication
import com.example.leo.testapp.config.TestAppComponent
import javax.inject.Inject


abstract class BaseActivity <P : BasePresenter<*>>: AppCompatActivity() {

    @Inject
    lateinit var mPresenter: P

    private var TAG: String?
        get() = this::class.simpleName
        set(value) = Unit

    private var mUnBinder: Unbinder? = null


    //region public method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Icepick.restoreInstanceState(this, savedInstanceState)
        mUnBinder = ButterKnife.bind(this)
        lifecycle.addObserver(mPresenter)


        try {
            injectActivity(TestAppApplication.component)
        } catch (e: Throwable) {
            Log.w(TAG, "${TestAppApplication::class.simpleName} could not injected => Method injectFragment(component: ${TestAppApplication::class.simpleName}) not implemented", e)
        }

        if (savedInstanceState == null) {
            // auto load default fragment if needed
            reset()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mUnBinder?.unbind()
        lifecycle.removeObserver(mPresenter)
    }

    override fun onBackPressed() {
        // keep last fragment
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    //endregion private methods
    abstract fun injectActivity(component: TestAppComponent)

    //endregion abstract method activity

    private fun clearBackStack() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate(null, 1)
        }
    }

    private fun reset() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}
