package five.interview.android.domain.repository

import five.interview.android.domain.model.Article
import five.interview.android.domain.model.Feed
import io.reactivex.Completable
import io.reactivex.Single


interface FeedRepository {

    fun addNewFeedSubscription(url : String) : Completable

    fun getUserFeeds(): Single<List<Feed>>

    fun getFeedArticles(feedId: Int): Single<List<Article>>

    fun deleteFeed(feedId: Int): Completable
}