package com.ginzo.feature.productlist

import android.app.Application
import android.app.Instrumentation
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.ginzo.feature.productlist.presentation.MockApp

class MockAndroidJUnitRunner : AndroidJUnitRunner() {
  override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
    return Instrumentation.newApplication(MockApp::class.java, context)
  }
}