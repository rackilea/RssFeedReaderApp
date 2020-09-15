package five.interview.android.rssfeedreaderapp.injection.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import five.interview.android.rssfeedreaderapp.injection.activity.DaggerActivity
import five.interview.android.rssfeedreaderapp.injection.factory.ComponentFactory
import five.interview.android.rssfeedreaderapp.injection.fragment.FragmentComponent

abstract class DaggerFragment : Fragment() {
    private var fragmentComponent: FragmentComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(getFragmentComponent())
    }

    protected abstract fun inject(component: FragmentComponent)

    fun getFragmentComponent(): FragmentComponent {
        if (fragmentComponent == null) {
            fragmentComponent =
                ComponentFactory.createFragmentComponent(this, getDaggerActivity()!!.getActivityComponent())
        }

        return this.fragmentComponent!!
    }

    fun getDaggerActivity(): DaggerActivity? {
        return activity as DaggerActivity?
    }
}