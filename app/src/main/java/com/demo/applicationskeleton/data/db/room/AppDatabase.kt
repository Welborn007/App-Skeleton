package com.vicky7230.headlines.data.db.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.demo.applicationskeleton.data.network.model.DomesticPackage

@Database(entities = [DomesticPackage::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
}