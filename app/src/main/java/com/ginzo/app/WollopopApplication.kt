package com.ginzo.app

import android.app.Application
import com.ginzo.app.di.ComponentManager

class WollopopApplication : Application() {

  private lateinit var componentManager: ComponentManager

  override fun onCreate() {
    super.onCreate()
    componentManager = ComponentManager()
  }
}