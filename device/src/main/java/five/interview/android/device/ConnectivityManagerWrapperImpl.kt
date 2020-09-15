package five.interview.android.device

import android.net.ConnectivityManager
import android.net.NetworkInfo

class ConnectivityManagerWrapperImpl(private val connectivityManager : ConnectivityManager) : ConnectivityManagerWrapper{

    override fun isConnectedToNetwork(): Boolean {

        val activeNetworkInfo = getActiveNetworkInfo()

        return activeNetworkInfo != null && activeNetworkInfo.isConnected

    }

    private fun getActiveNetworkInfo(): NetworkInfo? {
        return connectivityManager.activeNetworkInfo
    }
}