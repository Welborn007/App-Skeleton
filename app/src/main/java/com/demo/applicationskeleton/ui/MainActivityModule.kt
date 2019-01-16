package com.demo.applicationskeleton.ui

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.demo.applicationskeleton.di.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule{

    @Provides
    fun provideWebPackageAdapter(): WebPackageAdapter {
    return WebPackageAdapter(ArrayList())
}

@Provides
fun provideLinearLayoutManager(@ApplicationContext context: Context): LinearLayoutManager {
    return LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
}
}
