package five.interview.android.rssfeedreaderapp.injection.factory

import five.interview.android.rssfeedreaderapp.application.RssFeedReaderApplication
import five.interview.android.rssfeedreaderapp.injection.activity.ActivityComponent
import five.interview.android.rssfeedreaderapp.injection.activity.DaggerActivity
import five.interview.android.rssfeedreaderapp.injection.activity.DaggerActivityComponent
import five.interview.android.rssfeedreaderapp.injection.activity.module.ActivityModule
import five.interview.android.rssfeedreaderapp.injection.activity.module.ActivityPresenterModule
import five.interview.android.rssfeedreaderapp.injection.application.ApplicationComponent
import five.interview.android.rssfeedreaderapp.injection.application.DaggerApplicationComponent
import five.interview.android.rssfeedreaderapp.injection.application.module.ApplicationModule
import five.interview.android.rssfeedreaderapp.injection.fragment.DaggerFragment
import five.interview.android.rssfeedreaderapp.injection.fragment.DaggerFragmentComponent
import five.interview.android.rssfeedreaderapp.injection.fragment.FragmentComponent
import five.interview.android.rssfeedreaderapp.injection.fragment.module.FragmentModule
import five.interview.android.rssfeedreaderapp.injection.fragment.module.FragmentPresenterModule

class ComponentFactory {

    companion object {
        fun createApplicationComponent(application: RssFeedReaderApplication): ApplicationComponent {
            return DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(application))
                .build()
        }

        fun createActivityComponent(
            activity: DaggerActivity,
            application: RssFeedReaderApplication
        ): ActivityComponent {
            return DaggerActivityComponent.builder()
                .applicationComponent(application.getApplicationComponent())
                .activityModule(ActivityModule(activity))
                .activityPresenterModule(ActivityPresenterModule(activity))
                .build()
        }

        fun createFragmentComponent(fragment: DaggerFragment, component: ActivityComponent): FragmentComponent {
            return DaggerFragmentComponent.builder()
                .activityComponent(component)
                .fragmentModule(FragmentModule(fragment))
                .fragmentPresenterModule(FragmentPresenterModule(fragment))
                .build()
        }
    }

}