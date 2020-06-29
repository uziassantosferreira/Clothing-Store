package com.uziassantosferreira.store.beagle

import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.setup.BeagleConfig
import br.com.zup.beagle.android.setup.Cache
import br.com.zup.beagle.android.setup.Environment

@BeagleComponent
class AppBeagleConfig(
    override val baseUrl: String = "http://10.0.2.2:8080",
    override val cache: Cache = Cache(enabled = false, maxAge = 5L, memoryMaximumCapacity = 1),
    override val environment: Environment = Environment.DEBUG,
    override val isLoggingEnabled: Boolean = true
) : BeagleConfig
