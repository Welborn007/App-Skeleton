package com.vicky7230.headlines.data.db

import com.demo.applicationskeleton.data.network.model.DomesticPackage
import com.vicky7230.headlines.data.db.room.AppDatabase
import javax.inject.Inject

class AppDbHelper @Inject
constructor(private val appDatabase: AppDatabase) : DbHelper {

    override fun insertArticles(articles: MutableList<DomesticPackage>): List<Long> {
        return appDatabase.articleDao().insertArticles(articles)
    }

    override fun selectArticles(): List<DomesticPackage> {
        return appDatabase.articleDao().selectArticles()
    }

    override fun deleteArticles() {
        appDatabase.articleDao().deleteArticles()
    }
}