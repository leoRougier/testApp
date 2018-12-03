package com.example.leo.testapp.architecture

import android.app.Fragment
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

abstract class BasePresenter<out T : BaseView> : LifecycleObserver {

    private var mView: WeakReference<T>? = null
    protected val view: T?
        get() = mView?.get()

    private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }


    @Suppress("UNCHECKED_CAST")
    fun onViewAttach(view: BaseView) {
        mView = WeakReference(view as T)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun onDestroy() {
        mCompositeDisposable.dispose()
        mView?.clear()
    }

    fun lifecycleDisposable(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }

    protected fun getContext(): Context? {
        val view = mView?.get()
        return if (view is Context) view else if (view is Fragment) (view as Fragment).activity else null
    }
}