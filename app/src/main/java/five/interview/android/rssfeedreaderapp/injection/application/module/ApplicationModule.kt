package five.interview.android.rssfeedreaderapp.injection.application.module

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import five.interview.android.rssfeedreaderapp.application.RssFeedReaderApplication
import five.interview.android.rssfeedreaderapp.injection.qualifier.ForApplication
import javax.inject.Singleton

@Module
class ApplicationModule(private val application : RssFeedReaderApplication) {

    @Provides
    @ForApplication
    internal fun provideApplicationContext(): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideResources(): Resources {
        return application.resources
    }


    interface Exposes {

        @ForApplication
        fun context(): Context

        fun resources(): Resources
    }
}