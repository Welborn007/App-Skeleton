package com.vicky7230.headlines.data.db.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.applicationskeleton.data.network.model.Results

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(data: MutableList<Results>): List<Long>

    @Query("SELECT * FROM results")
    fun selectData(): List<Results>

    @Query("DELETE FROM results")
    fun deleteData()
}