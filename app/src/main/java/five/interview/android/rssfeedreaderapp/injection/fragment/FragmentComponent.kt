package five.interview.android.rssfeedreaderapp.injection.fragment

import dagger.Component
import five.interview.android.rssfeedreaderapp.injection.activity.ActivityComponent
import five.interview.android.rssfeedreaderapp.injection.fragment.module.FragmentModule
import five.interview.android.rssfeedreaderapp.injection.fragment.module.FragmentPresenterModule
import five.interview.android.rssfeedreaderapp.injection.scope.FragmentScope

@FragmentScope
@Component(
    dependencies = [ActivityComponent::class],
    modules = [
        FragmentModule::class,
        FragmentPresenterModule::class
    ]
)
interface FragmentComponent : FragmentComponentInjects, FragmentComponentExposes {

}