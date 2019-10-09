package com.ginzo.commons.feature_commons

import dagger.Component
import io.reactivex.Scheduler
import javax.inject.Named
import javax.inject.Singleton

@Component(modules = [FeatureModule::class])
interface FeatureComponent {
  @Component.Factory
  interface Factory {
    fun create(): FeatureComponent
  }

  @Named("main")
  fun mainScheduler(): Scheduler
}