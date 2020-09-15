package five.interview.android.data.api.model

import com.fasterxml.jackson.annotation.JsonProperty

class ApiChannel(
    @field:JsonProperty("channel")
    var feed : FeedApi) {

}