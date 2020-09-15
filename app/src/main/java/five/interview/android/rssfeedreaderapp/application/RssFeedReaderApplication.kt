package five.interview.android.rssfeedreaderapp.application

import android.app.Application
import android.content.Context
import five.interview.android.rssfeedreaderapp.injection.application.ApplicationComponent
import five.interview.android.rssfeedreaderapp.injection.factory.ComponentFactory

class RssFeedReaderApplication : Application() {

    companion object {
        fun from(context: Context): RssFeedReaderApplication {
            return RssFeedReaderApplication::class.java.cast(context.applicationContext)!!
        }
    }

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        initApplicationComponent()
        injectMe()
    }

    private fun initApplicationComponent() {
        applicationComponent = ComponentFactory.createApplicationComponent(this)
    }

    private fun injectMe() {
        applicationComponent.inject(this)
    }

    fun getApplicationComponent() : ApplicationComponent? {
        return applicationComponent
    }


}