package com.example.pollutionlevelchecker.di

import com.example.pollutionlevelchecker.network.ApiService
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
    fun provideRetrofitClient(url: String, gsonConverterFactory: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(url).client(okHttpClient).addConverterFactory(gsonConverterFactory).build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideBaseUrl(): String = "http://apis.data.go.kr"

    @Provides
    fun provideGsonConverter(): GsonConverterFactory = GsonConverterFactory.create(GsonBuilder().setLenient().create())

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES).build()
}