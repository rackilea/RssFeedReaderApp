package five.interview.android.rssfeedreaderapp.ui.subscription

import five.interview.android.rssfeedreaderapp.base.ScopedPresenter

interface MySubscriptionContract {

    interface Presenter : ScopedPresenter {

        fun addNewFeedSubscription(url : String)

        fun getAllUserSubscription()

    }

    interface View {

        fun showLoading()

        fun hideLoading()

        fun showNoInternetConnectionWarning()

        fun showSearchResult()

        fun showAllUserSubscription()

    }
}