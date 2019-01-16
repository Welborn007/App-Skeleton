package com.vicky7230.headlines.data.network

import com.demo.applicationskeleton.data.network.model.WebPackage
import io.reactivex.Observable

interface ApiHelper {
    fun getWebPackages(): Observable<WebPackage?>
}