package five.interview.android.data.dao

import androidx.room.Dao
import androidx.room.Insert
import five.interview.android.data.dao.entity.FeedEntity
import io.reactivex.Completable

@Dao
interface FeedDao {

    @Insert
    fun insert (feed: FeedEntity) : Completable

}