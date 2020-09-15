package five.interview.android.rssfeedreaderapp.injection.application

import dagger.Component
import five.interview.android.rssfeedreaderapp.injection.application.module.*
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class,
        DbModule::class,
        RepositoryModule::class,
        ServiceModule::class,
        UseCaseModule::class]
)
interface ApplicationComponent : ApplicationComponentInjects, ApplicationComponentExposes {}
