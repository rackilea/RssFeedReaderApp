package five.interview.android.rssfeedreaderapp.injection.activity

import dagger.Component
import five.interview.android.rssfeedreaderapp.injection.activity.module.ActivityModule
import five.interview.android.rssfeedreaderapp.injection.activity.module.ActivityPresenterModule
import five.interview.android.rssfeedreaderapp.injection.application.ApplicationComponent
import five.interview.android.rssfeedreaderapp.injection.scope.ActivityScope

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [
        ActivityModule::class,
        ActivityPresenterModule::class
    ]
)
interface ActivityComponent : ActivityComponentInjects, ActivityComponentExposes
