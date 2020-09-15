package five.interview.android.rssfeedreaderapp.injection.fragment.module

import dagger.Module
import dagger.Provides
import five.interview.android.rssfeedreaderapp.injection.fragment.DaggerFragment
import five.interview.android.rssfeedreaderapp.ui.subscription.MySubscriptionContract
import five.interview.android.rssfeedreaderapp.ui.subscription.MySubscriptionPresenter

@Module
class FragmentPresenterModule(private val fragment: DaggerFragment) {

    @Provides
    fun provideMySubscriptionPresenter(): MySubscriptionContract.Presenter {
        val presenter = MySubscriptionPresenter(fragment as MySubscriptionContract.View)
        fragment.getFragmentComponent().inject(presenter)
        return presenter
    }

    interface Exposes {

    }
}