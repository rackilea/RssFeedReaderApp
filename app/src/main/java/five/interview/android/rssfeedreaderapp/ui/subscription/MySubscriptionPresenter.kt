package five.interview.android.rssfeedreaderapp.ui.subscription

import android.util.Log
import five.interview.android.domain.usecase.addsubscription.AddNewSubscriptionUseCase
import five.interview.android.rssfeedreaderapp.base.BasePresenter
import javax.inject.Inject

class MySubscriptionPresenter(view : MySubscriptionContract.View) :
    BasePresenter<MySubscriptionContract.View>(view),
    MySubscriptionContract.Presenter {

    @Inject
    lateinit var addNewSubscriptionUseCase: AddNewSubscriptionUseCase


    override fun addNewFeedSubscription(url : String) {
        addDisposable(addNewSubscriptionUseCase.execute(url)
            .subscribeOn(backgroundScheduler)
            .observeOn(mainThreadScheduler)
            .subscribe(this::processSuccess,
                this::processFailure))
    }

    private fun processSuccess() {
        Log.d("MySubscriptionPresenter", "processAddNewSubscriptionUseCaseSuccess: success")
    }

    private fun processFailure(throwable: Throwable) {
        Log.e("MySubscriptionPresenter", "processAddNewSubscriptionUseCaseFailure: $throwable")
    }

    override fun getAllUserSubscription() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}