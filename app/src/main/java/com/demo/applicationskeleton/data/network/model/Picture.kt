package com.demo.applicationskeleton.data.network.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Picture(

    @SerializedName("large")
    @Expose
    @ColumnInfo(name = "large")
    var large: String? = null,

    @SerializedName("medium")
    @Expose
    @ColumnInfo(name = "medium")
    var medium: String? = null,

    @SerializedName("thumbnail")
    @Expose
    @ColumnInfo(name = "thumbnail")
    var thumbnail: String? = null

)
