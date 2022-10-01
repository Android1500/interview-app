package com.android1500.interviewapp.di

import android.app.Application
import androidx.room.Room
import com.android1500.interviewapp.api.ApiService
import com.android1500.interviewapp.room.AppDatabase
import com.android1500.interviewapp.room.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: AppDatabase.Callback)
            = Room.databaseBuilder(application, AppDatabase::class.java, "user_database")
        .addCallback(callback)
        .build()




    @Provides
    @Singleton
    fun provideDao(appDatabase: AppDatabase) : PostDao =
        appDatabase.postDao()

    @Singleton
    @Provides
    fun createApiService(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)




    @ApplicationScope
    @Provides
    @Singleton
    fun providesApplicationScope() = CoroutineScope(SupervisorJob())


    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class ApplicationScope




}