package com.example.pollutionlevelchecker.application

import android.app.Application
import com.example.pollutionlevelchecker.BuildConfig
import com.naver.maps.map.NaverMapSdk
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
//        NaverMapSdk.getInstance(this).apply {
////            setOnAuthFailedListener { authFailedException ->
//////                onAuthFailedListener = NaverMapSdk.OnAuthFailedListener { authFailedException ->
////                Timber.e("+++++++++++++++++++authFailed : ${authFailedException.message}")
//////                }
////            }
//            onAuthFailedListener = NaverMapSdk.OnAuthFailedListener { authFailedException ->
//                Timber.e("+++++++++++++++++++authFailed : ${authFailedException.message}")
//            }
//            client = NaverMapSdk.NaverCloudPlatformClient(BuildConfig.NAVER_CLIENT_ID)
//        }
    }
}