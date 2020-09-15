package five.interview.android.data.api

import five.interview.android.data.api.model.FeedApi
import io.reactivex.Single

interface RssApiService {

    fun getFeed(url : String) : Single<FeedApi>

    //fun getFeedArticles() : Single<List<ApiArticle>>
}