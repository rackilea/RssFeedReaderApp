package five.interview.android.data

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.Assert
import org.junit.Test
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import five.interview.android.data.api.model.ApiChannel
import five.interview.android.data.api.model.FeedApi


class RssApiServiceTest {

    private val okHttpClient by lazy {
        OkHttpClient()
    }

    @Test
    @Throws(Exception::class)
    fun testGettingDataFromRetrofitClientUsingJackson() {

        // Given
        val url = "https://www.index.hr/rss"

        // When
        val request = Request.Builder()
            .url(url)
            .build()
        val result = okHttpClient.newCall(request).execute()
        val raw = runCatching { result.body?.string() }.getOrNull()

        val xmlMapper = XmlMapper()
        val node = xmlMapper.readTree(raw)

        val jsonMapper = ObjectMapper()
        val json = jsonMapper.writeValueAsString(node);

        val mapper = jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        val value: ApiChannel = mapper.readValue(json)

        // Then
        Assert.assertNotNull(raw)
    }
}