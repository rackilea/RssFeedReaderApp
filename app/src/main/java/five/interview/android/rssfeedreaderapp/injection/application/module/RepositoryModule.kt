package five.interview.android.rssfeedreaderapp.injection.application.module

import dagger.Module
import dagger.Provides
import five.interview.android.data.api.RssApiService
import five.interview.android.data.dao.FeedDao
import five.interview.android.data.dao.mapper.DbMapper
import five.interview.android.data.repository.FeedRepositoryImpl
import five.interview.android.domain.repository.FeedRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideFeedRepository(
        rssService: RssApiService, feedDao: FeedDao, dbMapper: DbMapper
    ): FeedRepository {
        return FeedRepositoryImpl(rssService, feedDao, dbMapper)
    }

    interface Exposes {

        fun feedRepository() : FeedRepository

    }
}