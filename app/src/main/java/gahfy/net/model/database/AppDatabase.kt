package gahfy.net.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import gahfy.net.model.Post
import gahfy.net.model.PostDao

@Database(entities = arrayOf(Post::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}