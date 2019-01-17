package com.demo.applicationskeleton.data.network.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coordinates(

    @SerializedName("latitude")
    @Expose
    @ColumnInfo(name = "latitude")
    var latitude: String? = null,

    @SerializedName("longitude")
    @Expose
    @ColumnInfo(name = "longitude")
    var longitude: String? = null

)