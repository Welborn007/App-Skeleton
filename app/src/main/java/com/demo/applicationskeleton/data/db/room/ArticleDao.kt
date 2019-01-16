package com.vicky7230.headlines.data.db.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.demo.applicationskeleton.data.network.model.DomesticPackage

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(articles: MutableList<DomesticPackage>): List<Long>

    @Query("SELECT * FROM DOMESTIC_PACKAGE")
    fun selectArticles(): List<DomesticPackage>

    @Query("DELETE FROM DOMESTIC_PACKAGE")
    fun deleteArticles()
}