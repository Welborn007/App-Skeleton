package com.demo.applicationskeleton.data

import com.demo.applicationskeleton.data.network.model.DomesticPackage
import com.demo.applicationskeleton.data.network.model.WebPackage
import com.vicky7230.headlines.data.db.AppDbHelper
import com.vicky7230.headlines.data.network.AppApiHelper
import io.reactivex.Observable
import javax.inject.Inject

class AppDataManager @Inject constructor(private val appApiHelper: AppApiHelper, private val appDbHelper: AppDbHelper) : DataManager {

    override fun getWebPackages(): Observable<WebPackage?> {
        return appApiHelper.getWebPackages()
    }

    override fun insertArticles(articles: MutableList<DomesticPackage>): List<Long> {
        return appDbHelper.insertArticles(articles)
    }

    override fun selectArticles(): List<DomesticPackage> {
        return appDbHelper.selectArticles()
    }

    override fun deleteArticles() {
        appDbHelper.deleteArticles()
    }

}