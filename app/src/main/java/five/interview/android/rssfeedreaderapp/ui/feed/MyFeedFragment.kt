package five.interview.android.rssfeedreaderapp.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import five.interview.android.rssfeedreaderapp.R

class MyFeedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initFeedList()
    }

    private fun initFeedList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
