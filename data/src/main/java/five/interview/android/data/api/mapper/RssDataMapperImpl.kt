package five.interview.android.data.api.mapper

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import five.interview.android.data.api.model.FeedApi
import io.reactivex.Single

class RssDataMapperImpl : RssDataMapper {

    private val xmlMapper = XmlMapper()
    private val jsonMapper = ObjectMapper()

    override fun mapRssToApi(raw: String?): Single<FeedApi> {

        val node = xmlMapper.readTree(raw)
        val json = jsonMapper.writeValueAsString(node)

        val mapper = jacksonObjectMapper().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
            false
        )

        return mapper.readValue(json)
    }
}