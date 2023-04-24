package com.example.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.network.response.Item

@Database(entities = [Item::class], version = 1)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDAO(): ItemDAO

    companion object {
        @Volatile
        private var INSTANCE: ItemDatabase? = null
        private const val DB_NAME = "image_database"

        fun getDatabase(context: Context): ItemDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    DB_NAME
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}