package five.interview.android.data.api.model

import com.fasterxml.jackson.annotation.JsonProperty

class ApiArticle(
    @field:JsonProperty("title")
    var title: String,
    @field:JsonProperty("link")
    var link: String,
    @field:JsonProperty("description")
    var description: String,
    @field:JsonProperty("pubDate")
    var pubDate: String) {
}