package five.interview.android.data.dao.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "feeds",
    indices = [Index(
        value = ["url"],
        unique = true
    )]
)
class FeedEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "url")
    val link: String,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "image_url")
    val imageUrl: String?)