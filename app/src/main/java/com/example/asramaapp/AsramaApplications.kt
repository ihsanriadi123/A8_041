package com.example.asramaapp

import android.app.Application
import com.example.asramaapp.di.AppContainer
import com.example.asramaapp.di.AsramaContainer

class AsramaApplications:Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container= AsramaContainer()
    }

}