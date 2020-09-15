package five.interview.android.rssfeedreaderapp.injection.fragment

import five.interview.android.rssfeedreaderapp.ui.subscription.MySubscriptionFragment
import five.interview.android.rssfeedreaderapp.ui.subscription.MySubscriptionPresenter

interface FragmentComponentInjects {

    fun inject(presenter: MySubscriptionPresenter)

    fun inject(fragment: MySubscriptionFragment)

}