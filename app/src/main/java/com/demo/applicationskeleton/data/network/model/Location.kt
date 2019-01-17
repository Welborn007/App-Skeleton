package com.demo.applicationskeleton.data.network.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Location(

    @SerializedName("street")
    @Expose
    @ColumnInfo(name = "street")
    var street: String? = null,

    @SerializedName("city")
    @Expose
    @ColumnInfo(name = "city")
    var city: String? = null,

    @SerializedName("state")
    @Expose
    @ColumnInfo(name = "state")
    var state: String? = null,

    @SerializedName("postcode")
    @Expose
    @ColumnInfo(name = "postcode")
    var postcode: String? = null,

    @SerializedName("coordinates")
    @Expose
    @ColumnInfo(name = "coordinates")
    var coordinates: Coordinates? = null,

    @SerializedName("timezone")
    @Expose
    @ColumnInfo(name = "timezone")
    var timezone: Timezone? = null
)