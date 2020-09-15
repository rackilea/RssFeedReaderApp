package five.interview.android.rssfeedreaderapp.injection.application.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import five.interview.android.data.dao.FeedDao
import five.interview.android.data.dao.database.AppDatabase
import five.interview.android.data.dao.mapper.DbMapper
import five.interview.android.data.dao.mapper.DbMapperImpl
import five.interview.android.rssfeedreaderapp.injection.qualifier.ForApplication
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ForApplication context: Context?): AppDatabase {
        return Room.databaseBuilder<AppDatabase>(context!!, AppDatabase::class.java, "rss-db")
            .build()
    }

    @Provides
    @Singleton
    fun provideFeedDao(appDatabase: AppDatabase): FeedDao {
        return appDatabase.feedDao()
    }

    @Provides
    @Singleton
    fun provideDbMapper(): DbMapper {
        return DbMapperImpl()
    }

    interface Exposes {

        fun feedDao() : FeedDao
        fun dbMapper() : DbMapper

    }
}