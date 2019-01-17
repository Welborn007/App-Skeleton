package com.demo.applicationskeleton.data.network.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Name(

    @SerializedName("title")
    @Expose
    @ColumnInfo(name = "title")
    var title: String? = null,

    @SerializedName("first")
    @Expose
    @ColumnInfo(name = "first")
    var first: String? = null,

    @SerializedName("last")
    @Expose
    @ColumnInfo(name = "last")
    var last: String? = null

)
