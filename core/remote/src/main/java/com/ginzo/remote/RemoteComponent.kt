package com.ginzo.remote

import dagger.Component

@Component(modules = [RemoteModule::class])
interface RemoteComponent {
	@Component.Factory
	interface Factory {
		fun create(): RemoteComponent
	}

    fun responseTransformer(): ResponseTransformer
}
