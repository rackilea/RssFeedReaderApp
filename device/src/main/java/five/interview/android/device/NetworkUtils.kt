package five.interview.android.device

import io.reactivex.Single

interface NetworkUtils {

    fun isConnectedToInternet(): Single<Boolean>
}