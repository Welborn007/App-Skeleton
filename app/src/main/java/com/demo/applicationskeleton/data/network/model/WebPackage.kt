package com.demo.applicationskeleton.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WebPackage (

    @SerializedName("status")
    @Expose
    var status: String? = null,
    @SerializedName("totalResults")
    @Expose
    var totalResults: Int? = null,
    @SerializedName("DOMESTIC_PACKAGE")
    @Expose
    var DOMESTIC_PACKAGE: List<DomesticPackage>? = null
)