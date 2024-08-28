package com.triosng2024.treasurehunt.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.triosng2024.treasurehunt.model.Bookmark


@Database(entities = arrayOf(Bookmark::class), version = 1)
abstract class TreasureHuntDatabase : RoomDatabase() {

    abstract fun bookmarkDao(): BookmarkDao

    companion object {
        private var instance: TreasureHuntDatabase? = null

        fun getIntstance(context: Context): TreasureHuntDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    TreasureHuntDatabase::class.java,
                    "TreasureHunt").build()
            }
            return instance as TreasureHuntDatabase
        }
    }
}