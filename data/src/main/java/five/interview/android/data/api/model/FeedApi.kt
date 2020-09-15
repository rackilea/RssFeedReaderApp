package five.interview.android.data.api.model

import com.fasterxml.jackson.annotation.JsonProperty


class FeedApi (
    @field:JsonProperty("title")
    var title : String,
    @field:JsonProperty("link")
    var link : String,
    @field:JsonProperty("description")
    var description: String,
    @field:JsonProperty("url")
    var imageUrl : String? = null,
    @field:JsonProperty("item")
    var articles : List<ApiArticle>){

}