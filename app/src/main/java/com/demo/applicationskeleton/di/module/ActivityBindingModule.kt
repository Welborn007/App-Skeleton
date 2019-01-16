package com.demo.applicationskeleton.di.module

import com.demo.applicationskeleton.ui.MainActivity
import com.demo.applicationskeleton.ui.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindNewsActivity(): MainActivity
}