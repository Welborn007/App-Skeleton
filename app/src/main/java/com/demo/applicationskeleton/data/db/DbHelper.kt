package com.vicky7230.headlines.data.db

import com.demo.applicationskeleton.data.network.model.Results

interface DbHelper {

    fun insertData(data: MutableList<Results>): List<Long>

    fun selectData(): List<Results>

    fun deleteData()
}