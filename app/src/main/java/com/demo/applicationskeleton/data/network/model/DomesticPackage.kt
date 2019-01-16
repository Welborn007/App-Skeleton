package com.demo.applicationskeleton.data.network.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.vicky7230.headlines.data.db.room.Converters

@Entity(tableName = "DOMESTIC_PACKAGE")
@TypeConverters(Converters::class)
data class DomesticPackage(
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    var name: String? = null,

    @SerializedName("image")
    @Expose
    @ColumnInfo(name = "image")
    var image: String? = null
)
