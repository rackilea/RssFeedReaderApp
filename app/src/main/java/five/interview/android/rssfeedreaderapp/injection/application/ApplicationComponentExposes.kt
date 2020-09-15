package five.interview.android.rssfeedreaderapp.injection.application

import five.interview.android.rssfeedreaderapp.injection.application.module.*

interface ApplicationComponentExposes : ApplicationModule.Exposes,
    DbModule.Exposes, RepositoryModule.Exposes, ServiceModule.Exposes,
    UseCaseModule.Exposes {

}