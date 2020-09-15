package five.interview.android.rssfeedreaderapp.injection.activity

import five.interview.android.rssfeedreaderapp.ui.MainActivity
import five.interview.android.rssfeedreaderapp.ui.MainPresenter

interface ActivityComponentInjects {

    fun inject(activity: MainActivity)

    fun inject(presenter: MainPresenter)

}