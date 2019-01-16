package com.vicky7230.headlines.data.network

import com.demo.applicationskeleton.data.network.model.WebPackage
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override fun getWebPackages(): Observable<WebPackage?> {
        return apiService.getWebPackages()
    }
}