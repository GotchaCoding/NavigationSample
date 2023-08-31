package org.techtown.weathersystem.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.techtown.weathersystem.di.kbs.KbsProvider
import org.techtown.weathersystem.di.kbs.KbsProviderImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class BroadCastModule {

    @Binds
    abstract fun provideKbs(kbsProviderImpl : KbsProviderImpl) : KbsProvider
}