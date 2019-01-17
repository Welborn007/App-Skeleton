package com.demo.applicationskeleton.ui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.demo.applicationskeleton.di.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule{

    @Provides
    fun provideWebPackageAdapter(): ResultsAdapter {
    return ResultsAdapter(ArrayList())
}

@Provides
fun provideLinearLayoutManager(@ApplicationContext context: Context): androidx.recyclerview.widget.LinearLayoutManager {
    return androidx.recyclerview.widget.LinearLayoutManager(
        context,
        RecyclerView.VERTICAL,
        false
    )
}
}
