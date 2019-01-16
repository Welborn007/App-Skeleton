package com.vicky7230.headlines.data.network

import com.demo.applicationskeleton.data.network.model.WebPackage
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("api/?results=10")
    fun getWebPackages(): Observable<WebPackage?>
}