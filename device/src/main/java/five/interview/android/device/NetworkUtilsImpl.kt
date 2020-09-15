package five.interview.android.device

import com.annimon.stream.Optional
import io.reactivex.Single

import java.net.InetAddress
import java.net.UnknownHostException

class NetworkUtilsImpl(val connectivityManagerWrapper : ConnectivityManagerWrapper) : NetworkUtils{

    private val PING_ADDRESS = "www.google.com"
    private val EMPTY = ""

    override fun isConnectedToInternet(): Single<Boolean> {
        return Single.fromCallable { isConnectedToNetwork() && canResolveAddress(PING_ADDRESS) }
    }

    private fun isConnectedToNetwork(): Boolean {
        return connectivityManagerWrapper.isConnectedToNetwork()
    }

    private fun canResolveAddress(url: String): Boolean {
        return pingAddress(url)
    }

    private fun pingAddress(url: String): Boolean {

        try {
            return Optional.ofNullable(InetAddress.getByName(url))
                .map(InetAddress::getAddress)
                .map { value -> !EMPTY.equals(value) }
                .orElse(false)

        } catch (e: UnknownHostException) {
            return false
        }

    }

}