package five.interview.android.data.dao.mapper

import five.interview.android.data.api.model.FeedApi
import five.interview.android.data.dao.entity.FeedEntity

class DbMapperImpl : DbMapper {
    override fun mapApiFeedToDbEntity(feedApi: FeedApi): FeedEntity {
        return FeedEntity(0, feedApi.title, feedApi.link, feedApi.description, feedApi.imageUrl)
    }
}