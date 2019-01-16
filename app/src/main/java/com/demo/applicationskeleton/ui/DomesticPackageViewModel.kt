package com.demo.applicationskeleton.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.demo.applicationskeleton.data.DataManager
import com.demo.applicationskeleton.data.network.model.DomesticPackage
import com.demo.applicationskeleton.data.network.model.WebPackage
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class DomesticPackageViewModel(
        context: Application,
        private val dataManager: DataManager
)
    : AndroidViewModel(context) {

    fun getArticlesFromDatabase(): Observable<WebPackage?> {
        return Observable.defer { Observable.just(dataManager.selectArticles()) }
                .map { it: List<DomesticPackage> ->
                    val headlines: WebPackage? = WebPackage(
                            "OK",
                            20,
                            it)
                    headlines
                }
                .subscribeOn(Schedulers.computation())
    }

    fun getArticlesFromNetwork(): Observable<WebPackage?> {
        return dataManager.getWebPackages()
                .map { it: WebPackage? ->
                    if (it?.DOMESTIC_PACKAGE != null) {
                        dataManager.deleteArticles()
                        dataManager.insertArticles(it.DOMESTIC_PACKAGE as MutableList<DomesticPackage>)
                    }
                    it
                }
                .subscribeOn(Schedulers.io())
    }
}
