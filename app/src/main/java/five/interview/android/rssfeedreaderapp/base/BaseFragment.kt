package five.interview.android.rssfeedreaderapp.base

import android.os.Bundle
import com.annimon.stream.Optional
import five.interview.android.rssfeedreaderapp.injection.fragment.DaggerFragment

abstract class BaseFragment : DaggerFragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresenter().start()
    }

    override fun onStop() {
        getPresenter().stop()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        getPresenter().activate()
    }

    override fun onPause() {
        getPresenter().deactivate()
        super.onPause()
    }

    open fun onPreDestroy() {
        Optional.ofNullable(getPresenter())
            .ifPresent(ScopedPresenter::destroy)
    }

    override fun onDestroy() {
        onPreDestroy()
        super.onDestroy()
    }

    abstract fun getPresenter(): ScopedPresenter

}