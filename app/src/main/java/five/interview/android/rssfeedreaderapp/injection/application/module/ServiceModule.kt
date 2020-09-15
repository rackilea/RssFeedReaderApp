package five.interview.android.rssfeedreaderapp.injection.application.module

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper

import dagger.Module
import dagger.Provides
import five.interview.android.data.api.RssApiService
import five.interview.android.data.api.RssApiServiceImpl
import five.interview.android.data.api.mapper.RssDataMapper
import five.interview.android.data.api.mapper.RssDataMapperImpl
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideRssApiService(mapper : RssDataMapper): RssApiService {
        return RssApiServiceImpl(mapper)
    }

    @Provides
    @Singleton
    fun provideRssDataMapper(): RssDataMapper {
        return RssDataMapperImpl()
    }

    interface Exposes {

        fun rssApiService() : RssApiService
        fun rssDataMapper() : RssDataMapper
    }
}