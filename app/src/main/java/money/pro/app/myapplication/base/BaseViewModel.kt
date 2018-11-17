package money.pro.app.myapplication.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel<Navigator> : ViewModel() {
    var navigator: Navigator? = null
    var compoDisposable = CompositeDisposable()
    fun addDisposable(disposable: Disposable) {
        compoDisposable.add(disposable)
    }

    fun onActivityDestroy() {
        compoDisposable.clear()
    }
}