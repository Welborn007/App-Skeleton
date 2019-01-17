package com.demo.applicationskeleton.data.network.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DOB(

    @SerializedName("date")
    @Expose
    @ColumnInfo(name = "date")
    var date: String? = null,

    @SerializedName("age")
    @Expose
    @ColumnInfo(name = "age")
    var age: String? = null

)