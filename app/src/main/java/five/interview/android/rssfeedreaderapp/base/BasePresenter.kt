package five.interview.android.rssfeedreaderapp.base

import five.interview.android.rssfeedreaderapp.utils.ViewActionQueue
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.lang.ref.WeakReference

abstract class BasePresenter<View>(private val view : View) : ScopedPresenter {

    protected var mainThreadScheduler: Scheduler = AndroidSchedulers.mainThread()

    protected var backgroundScheduler: Scheduler = Schedulers.io()

    private var viewReference : WeakReference<View> = WeakReference(view)

    private var viewActionsSubscription: Disposable? = null

    protected val viewActionQueue: ViewActionQueue<View> = ViewActionQueue()

    private val disposables = CompositeDisposable()
    private val permissionSubscriptions = CompositeDisposable()

    override fun start() {
    }

    override fun activate() {
    }

    override fun deactivate() {
    }

    override fun stop() {
    }

    override fun destroy() {
    }

    override fun back() {
    }

    protected open fun addDisposable(disposable: Disposable?) {
        disposables.add(disposable!!)
    }
}