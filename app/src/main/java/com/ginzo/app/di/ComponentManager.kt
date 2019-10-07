package com.ginzo.app.di

import android.app.Application
import com.ginzo.remote.DaggerRemoteComponent
import com.ginzo.remote.RemoteComponent

class ComponentManager(application: Application) {

	internal val remoteComponent: RemoteComponent by lazy {
		DaggerRemoteComponent.create()
	}
}