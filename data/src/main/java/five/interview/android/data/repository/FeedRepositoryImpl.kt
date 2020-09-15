package five.interview.android.data.repository

import five.interview.android.data.api.RssApiService
import five.interview.android.data.dao.FeedDao
import five.interview.android.data.dao.mapper.DbMapper
import five.interview.android.domain.model.Article
import five.interview.android.domain.model.Feed
import five.interview.android.domain.repository.FeedRepository
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class FeedRepositoryImpl(
    private val rssService: RssApiService,
    private val feedDao: FeedDao,
    private val dbMapper: DbMapper
) : FeedRepository {

    private val backgroundScheduler: Scheduler = Schedulers.io()

    override fun addNewFeedSubscription(url: String): Completable {

        return Completable.defer {
            rssService.getFeed(url).map{ feedApi -> dbMapper.mapApiFeedToDbEntity(feedApi) }
                .flatMapCompletable(feedDao::insert)
        }
            .subscribeOn(backgroundScheduler)
    }

    override fun getUserFeeds(): Single<List<Feed>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFeedArticles(feedId: Int): Single<List<Article>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteFeed(feedId: Int): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}