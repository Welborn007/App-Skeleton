package com.demo.applicationskeleton.ui

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
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
fun provideLinearLayoutManager(@ApplicationContext context: Context): androidx.recyclerview.widget.LinearLayoutManager {
    return androidx.recyclerview.widget.LinearLayoutManager(
        context,
        androidx.recyclerview.widget.LinearLayoutManager.VERTICAL,
        false
    )
}
}
