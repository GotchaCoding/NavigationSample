package org.techtown.weathersystem.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.techtown.weathersystem.Kbs
import org.techtown.weathersystem.KbsImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BroadCastModule {

    @Binds
    @Singleton
    abstract fun bindsKbs(kbs : KbsImpl) : Kbs

//    @Binds
//    abstract fun bindsKbs(sbs : SbsImpl) : Sbs
}