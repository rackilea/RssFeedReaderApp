package five.interview.android.rssfeedreaderapp.injection.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import five.interview.android.rssfeedreaderapp.application.RssFeedReaderApplication
import five.interview.android.rssfeedreaderapp.injection.factory.ComponentFactory

abstract class DaggerActivity : AppCompatActivity() {

    private var activityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(getActivityComponent())
    }

    fun getActivityComponent(): ActivityComponent {
        if (activityComponent == null) {
            activityComponent = ComponentFactory.createActivityComponent(this, getApp())
        }

        return activityComponent as ActivityComponent
    }

    private fun getApp(): RssFeedReaderApplication {
        return RssFeedReaderApplication.from(this)
    }

    protected abstract fun inject(component: ActivityComponent?)
}