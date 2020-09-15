package five.interview.android.rssfeedreaderapp.injection.activity.module

import dagger.Module
import dagger.Provides
import five.interview.android.rssfeedreaderapp.injection.activity.DaggerActivity
import five.interview.android.rssfeedreaderapp.injection.scope.ActivityScope
import five.interview.android.rssfeedreaderapp.ui.MainContract
import five.interview.android.rssfeedreaderapp.ui.MainPresenter
import five.interview.android.rssfeedreaderapp.ui.subscription.MySubscriptionContract

@Module
class ActivityPresenterModule(private val activity: DaggerActivity) {

    @Provides
    @ActivityScope
    fun provideMainPresenter(): MainContract.Presenter {
        val presenter = MainPresenter(activity as MainContract.View)
        activity.getActivityComponent().inject(presenter)
        return presenter
    }

    interface Exposes {

    }
}