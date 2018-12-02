package com.example.leo.testapp.architecture

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.leo.testapp.config.TestAppApplication
import com.example.leo.testapp.config.TestAppComponent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import javax.inject.Inject

abstract class BaseFragment <P : BasePresenter<*>> : Fragment(), BaseView {

    @Inject
    lateinit var mPresenter: P


    private var mUnBinder: Unbinder? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFragment(TestAppApplication.component)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mUnBinder = ButterKnife.bind(this, view)
        mPresenter.onViewAttach(this)
        lifecycle.addObserver(mPresenter)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        lifecycle.removeObserver(mPresenter)
        mUnBinder?.unbind()
    }

    abstract fun injectFragment(component: TestAppComponent)

}