package five.interview.android.rssfeedreaderapp.ui.subscription


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import five.interview.android.rssfeedreaderapp.R
import five.interview.android.rssfeedreaderapp.base.BaseFragment
import five.interview.android.rssfeedreaderapp.base.ScopedPresenter
import five.interview.android.rssfeedreaderapp.injection.fragment.FragmentComponent
import kotlinx.android.synthetic.main.fragment_add_subscription.*
import javax.inject.Inject


class MySubscriptionFragment : BaseFragment(), MySubscriptionContract.View {

    @Inject
    lateinit var presenter: MySubscriptionContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_subscription, container, false)
    }

    override fun getPresenter(): ScopedPresenter {
        return presenter
    }

    override fun inject(component: FragmentComponent) {
        component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newSubscriptionUrlSearchButton.setOnClickListener { v ->
            checkNetworkConnectivity()
        }
    }

    private fun checkNetworkConnectivity() {
        if (isConnectedToInternet()) {
            showLoading()
            presenter.addNewFeedSubscription(newSubscriptionUrlInput.text.toString())
        } else {
            showNoInternetConnectionWarning()
        }
    }

    private fun isConnectedToInternet(): Boolean {
        return true
    }

    override fun showLoading() {
        //TODO
    }

    override fun hideLoading() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoInternetConnectionWarning() {
        //TODO
    }

    override fun showSearchResult() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showAllUserSubscription() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
