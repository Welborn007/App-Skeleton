package com.demo.applicationskeleton.data

import com.demo.applicationskeleton.data.network.model.Results
import com.demo.applicationskeleton.data.network.model.WebPackage
import com.vicky7230.headlines.data.db.AppDbHelper
import com.vicky7230.headlines.data.network.AppApiHelper
import io.reactivex.Observable
import javax.inject.Inject

class AppDataManager @Inject constructor(private val appApiHelper: AppApiHelper, private val appDbHelper: AppDbHelper) : DataManager {

    override fun getWebPackages(): Observable<WebPackage?> {
        return appApiHelper.getWebPackages()
    }

    override fun insertData(articles: MutableList<Results>): List<Long> {
        return appDbHelper.insertData(articles)
    }

    override fun selectData(): List<Results> {
        return appDbHelper.selectData()
    }

    override fun deleteData() {
        appDbHelper.deleteData()
    }

}