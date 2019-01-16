package com.vicky7230.headlines.data.db

import com.demo.applicationskeleton.data.network.model.DomesticPackage

interface DbHelper {

    fun insertArticles(articles: MutableList<DomesticPackage>): List<Long>

    fun selectArticles(): List<DomesticPackage>

    fun deleteArticles()
}