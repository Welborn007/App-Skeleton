package com.demo.applicationskeleton.di.component

import com.demo.applicationskeleton.SkeletonApplication
import com.demo.applicationskeleton.di.module.ActivityBindingModule
import com.demo.applicationskeleton.di.module.ApplicationModule
import com.demo.applicationskeleton.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    ApplicationModule::class,
    ActivityBindingModule::class
])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(skeletonApplication: SkeletonApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(skeletonApplication: SkeletonApplication)

}