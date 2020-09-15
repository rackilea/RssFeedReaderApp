package five.interview.android.rssfeedreaderapp.injection.activity

import five.interview.android.rssfeedreaderapp.injection.activity.module.ActivityModule
import five.interview.android.rssfeedreaderapp.injection.activity.module.ActivityPresenterModule
import five.interview.android.rssfeedreaderapp.injection.application.ApplicationComponentExposes

interface ActivityComponentExposes : ApplicationComponentExposes, ActivityModule.Exposes,
    ActivityPresenterModule.Exposes {

}