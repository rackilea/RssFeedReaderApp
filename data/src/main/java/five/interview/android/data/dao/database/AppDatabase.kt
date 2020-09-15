package five.interview.android.data.dao.database

import androidx.room.Database
import androidx.room.RoomDatabase
import five.interview.android.data.dao.FeedDao
import five.interview.android.data.dao.entity.FeedEntity

@Database(entities = [FeedEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun feedDao(): FeedDao
}