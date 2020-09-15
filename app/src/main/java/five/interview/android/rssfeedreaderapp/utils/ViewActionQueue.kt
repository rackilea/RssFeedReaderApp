package five.interview.android.rssfeedreaderapp.utils

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import java.util.*

class ViewActionQueue<View> {

    private val viewActions = LinkedList<Consumer<View>>()
    private val queueLock = Any()

    private val viewActionSubject = PublishSubject.create<Consumer<View>>()
    private val subscriptions = CompositeDisposable()

    private var isPaused = true

    fun subscribeTo(
        observable: Observable<Consumer<View>>,
        onCompleteAction: Consumer<View>,
        errorAction: Consumer<Throwable>
    ) {
        subscriptions.add(
            observable.observeOn(AndroidSchedulers.mainThread()).subscribe(
                Consumer { this.onResult(it) },
                errorAction,
                Action { onResult(onCompleteAction) })
        )
    }

    fun subscribeTo(single: Single<Consumer<View>>, errorAction: Consumer<Throwable>) {
        subscriptions.add(
            single.observeOn(AndroidSchedulers.mainThread()).subscribe(
                Consumer { this.onResult(it) },
                errorAction
            )
        )
    }

    fun subscribeTo(completable: Completable, onCompleteAction: Consumer<View>, errorAction: Consumer<Throwable>) {
        subscriptions.add(
            completable.observeOn(AndroidSchedulers.mainThread()).subscribe(Action { onResult(onCompleteAction) },
                errorAction
            )
        )
    }

    private fun onResult(resultAction: Consumer<View>) {
        if (isPaused) {
            synchronized(queueLock) {
                viewActions.add(resultAction)
            }
        } else {
            viewActionSubject.onNext(resultAction)
        }
    }

    fun scheduleViewAction(action: Consumer<View>) {
        onResult(action)
    }

    fun pause() {
        isPaused = true
    }

    fun resume() {
        isPaused = false
        consumeQueue()
    }

    fun destroy() {
        subscriptions.dispose()
        viewActionSubject.onComplete()
    }

    private fun consumeQueue() {
        synchronized(queueLock) {
            val actionIterator = viewActions.iterator()
            while (actionIterator.hasNext()) {
                val pendingViewAction = actionIterator.next()
                viewActionSubject.onNext(pendingViewAction)
                actionIterator.remove()
            }
        }
    }

    fun viewActionsObservable(): Observable<Consumer<View>> {
        return viewActionSubject
    }

}