package com.example.pollutionlevelchecker.di

import com.example.pollutionlevelchecker.network.ApiService
import com.example.pollutionlevelchecker.network.MainRetrofitClient
import com.example.pollutionlevelchecker.network.NaverMapsApiService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(mainRetrofitClient: MainRetrofitClient): ApiService =
        mainRetrofitClient.createRetrofitClient(ApiService::class.java, false, "http://apis.data.go.kr")

    @Provides
    @Singleton
    fun provideNaverMapsApiService(mainRetrofitClient: MainRetrofitClient): NaverMapsApiService =
        mainRetrofitClient.createRetrofitClient(NaverMapsApiService::class.java, true, "https://naveropenapi.apigw.ntruss.com/")
}