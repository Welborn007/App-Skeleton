package com.demo.applicationskeleton.data.network.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Login(

    @SerializedName("uuid")
    @Expose
    @ColumnInfo(name = "uuid")
    var uuid: String? = null,

    @SerializedName("username")
    @Expose
    @ColumnInfo(name = "username")
    var username: String? = null,

    @SerializedName("password")
    @Expose
    @ColumnInfo(name = "password")
    var password: String? = null,

    @SerializedName("salt")
    @Expose
    @ColumnInfo(name = "salt")
    var salt: String? = null,

    @SerializedName("md5")
    @Expose
    @ColumnInfo(name = "md5")
    var md5: String? = null,

    @SerializedName("sha1")
    @Expose
    @ColumnInfo(name = "sha1")
    var sha1: String? = null,

    @SerializedName("sha256")
    @Expose
    @ColumnInfo(name = "sha256")
    var sha256: String? = null

)