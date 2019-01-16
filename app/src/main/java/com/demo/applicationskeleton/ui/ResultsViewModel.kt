package com.demo.applicationskeleton.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.demo.applicationskeleton.data.DataManager
import com.demo.applicationskeleton.data.network.model.Results
import com.demo.applicationskeleton.data.network.model.WebPackage
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class ResultsViewModel(
        context: Application,
        private val dataManager: DataManager
)
    : AndroidViewModel(context) {

    fun getArticlesFromDatabase(): Observable<WebPackage?> {
        return Observable.defer { Observable.just(dataManager.selectData()) }
                .map { it: List<Results> ->
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
                    if (it?.results != null) {
                        dataManager.deleteData()
                        dataManager.insertData(it.results as MutableList<Results>)
                    }
                    it
                }
                .subscribeOn(Schedulers.io())
    }
}
