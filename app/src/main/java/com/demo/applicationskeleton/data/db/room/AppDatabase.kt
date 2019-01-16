package com.vicky7230.headlines.data.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.applicationskeleton.data.network.model.Results

@Database(entities = [Results::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
}