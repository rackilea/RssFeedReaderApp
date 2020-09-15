package five.interview.android.data.api.mapper

import five.interview.android.data.api.model.FeedApi
import io.reactivex.Single

interface RssDataMapper {

    fun mapRssToApi(raw : String?) : Single<FeedApi>
}