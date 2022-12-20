package com.example.pollutionlevelchecker.network

import com.example.pollutionlevelchecker.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRetrofitClient @Inject constructor() {
    fun <T> createRetrofitClient(cls: Class<T>, isNaverMapCall: Boolean, baseUrl: String): T {
        val okHttpClient = createOkHttpClient(isNaverMapCall)
        val gsonConverter = createGsonConverter()

        val retrofit = Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient).addConverterFactory(gsonConverter).build()
        return retrofit.create(cls)
    }

    private fun createGsonConverter(): GsonConverterFactory {
        val gson = GsonBuilder().setLenient().create()
        return GsonConverterFactory.create(gson)
    }

    private fun createOkHttpClient(isNaverMapCall: Boolean): OkHttpClient {
        val client = OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES)

        if (isNaverMapCall) {
            val headerInterceptor = HeaderInterceptor()
            val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            return client.addInterceptor(headerInterceptor).addInterceptor(logging).build()
        }

        return client.build()
    }
}

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        val newRequest = request().newBuilder()
            .addHeader("X-NCP-APIGW-API-KEY-ID", BuildConfig.NAVER_CLIENT_ID)
            .addHeader("X-NCP-APIGW-API-KEY", BuildConfig.NAVER_CLIENT_SECRET)
            .build()
        proceed(newRequest)
    }
}