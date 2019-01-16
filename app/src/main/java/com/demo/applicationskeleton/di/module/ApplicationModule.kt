package com.demo.applicationskeleton.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import com.demo.applicationskeleton.R
import com.demo.applicationskeleton.SkeletonApplication
import com.demo.applicationskeleton.data.AppDataManager
import com.demo.applicationskeleton.data.Config
import com.demo.applicationskeleton.data.DataManager
import com.demo.applicationskeleton.di.ApplicationContext
import com.demo.applicationskeleton.di.BaseUrl
import com.vicky7230.headlines.data.db.AppDbHelper
import com.vicky7230.headlines.data.db.DbHelper
import com.vicky7230.headlines.data.db.room.AppDatabase
import com.vicky7230.headlines.data.network.ApiHelper
import com.vicky7230.headlines.data.network.AppApiHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @ApplicationContext
    internal fun provideContext(headlinesApplication: SkeletonApplication): Context {
        return headlinesApplication.applicationContext
    }

    @Provides
    internal fun provideApplication(headlinesApplication: SkeletonApplication): Application {
        return headlinesApplication
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    fun provideCustomTabsIntent(@ApplicationContext context: Context): CustomTabsIntent {
        return CustomTabsIntent.Builder()
                .setShowTitle(true)
                .setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setSecondaryToolbarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
                .addDefaultShareMenuItem()
                .build()
    }

    @Provides
    @BaseUrl
    internal fun provideBaseUrl(): String {
        return Config.BASE_URL
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, Config.DB_NAME)
                .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

}