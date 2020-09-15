package five.interview.android.data.api

import android.util.Log
import five.interview.android.data.api.mapper.RssDataMapper
import five.interview.android.data.api.model.FeedApi
import io.reactivex.CompletableSource
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class RssApiServiceImpl(private val mapper : RssDataMapper) : RssApiService {

    private val okHttpClient by lazy {
        OkHttpClient()
    }

    private val backgroundScheduler: Scheduler = Schedulers.io()

    override fun getFeed(url: String): Single<FeedApi> {
        val request = buildRequest(url)


        return CompletableSource {okHttpClient.newCall(request).execute()}
            .map { response: Response -> runCatching { response.body?.string() }.getOrNull() }
            .flatMap { response: String -> mapper.mapRssToApi(response) }
            .subscribeOn(backgroundScheduler)
            .doOnSuccess { processSuccess() }
            .doOnError { t : Throwable? -> processError(t) }
    }

    private fun processSuccess(){
        Log.d("getFeed", "success")
    }

    private fun processError(t : Throwable?){
        Log.d("getFeed", "error: $t")
    }

    private fun buildRequest(url: String): Request {
        return Request.Builder()
            .url(url)
            .build()
    }


}