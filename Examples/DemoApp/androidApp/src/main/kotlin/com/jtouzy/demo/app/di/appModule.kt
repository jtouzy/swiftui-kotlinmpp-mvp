package com.jtouzy.demo.app.di

import com.jtouzy.demo.app.ui.NavigationManager
import com.jtouzy.demo.cache.DataStore
import com.jtouzy.demo.cache.InMemoryDataStore
import com.jtouzy.demo.network.BreakingBadApi
import org.koin.dsl.module

val appModule = module {

    single { NavigationManager() }
    single { BreakingBadApi() }
    single<DataStore> { InMemoryDataStore(get()) }
}
