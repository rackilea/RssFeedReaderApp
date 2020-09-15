package five.interview.android.data.dao.mapper

import five.interview.android.data.api.model.FeedApi
import five.interview.android.data.dao.entity.FeedEntity

interface DbMapper {

    fun mapApiFeedToDbEntity(feedApi: FeedApi) : FeedEntity
}