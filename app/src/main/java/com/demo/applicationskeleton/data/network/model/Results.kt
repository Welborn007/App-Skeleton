package com.demo.applicationskeleton.data.network.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.vicky7230.headlines.data.db.room.Converters

@Entity(tableName = "results")
@TypeConverters(Converters::class)
data class Results(
    @PrimaryKey(autoGenerate = true)
    var idNum: Long,

    @SerializedName("gender")
    @Expose
    @ColumnInfo(name = "gender")
    var gender: String? = null,

    @SerializedName("email")
    @Expose
    @ColumnInfo(name = "email")
    var email: String? = null,

    @SerializedName("phone")
    @Expose
    @ColumnInfo(name = "phone")
    var phone: String? = null,

    @SerializedName("cell")
    @Expose
    @ColumnInfo(name = "cell")
    var cell: String? = null,

    @SerializedName("nat")
    @Expose
    @ColumnInfo(name = "nat")
    var nat: String? = null,

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    var name: Name? = null
)
