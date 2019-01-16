package com.vicky7230.headlines.data.db

import com.demo.applicationskeleton.data.network.model.Results
import com.vicky7230.headlines.data.db.room.AppDatabase
import javax.inject.Inject

class AppDbHelper @Inject
constructor(private val appDatabase: AppDatabase) : DbHelper {

    override fun insertData(articles: MutableList<Results>): List<Long> {
        return appDatabase.articleDao().insertData(articles)
    }

    override fun selectData(): List<Results> {
        return appDatabase.articleDao().selectData()
    }

    override fun deleteData() {
        appDatabase.articleDao().deleteData()
    }
}