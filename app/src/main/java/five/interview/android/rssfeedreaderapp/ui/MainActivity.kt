package five.interview.android.rssfeedreaderapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import five.interview.android.rssfeedreaderapp.R
import five.interview.android.rssfeedreaderapp.base.BaseActivity
import five.interview.android.rssfeedreaderapp.injection.activity.ActivityComponent
import five.interview.android.rssfeedreaderapp.ui.feed.MyFeedFragment
import five.interview.android.rssfeedreaderapp.ui.subscription.MySubscriptionFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), MainContract.View {

    private val titles = arrayOf("My feed", "My subscription")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }

    override fun inject(component: ActivityComponent?) {
        component?.inject(this)
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = titles.size

        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> MyFeedFragment()
            else -> MySubscriptionFragment()
        }
    }
}
