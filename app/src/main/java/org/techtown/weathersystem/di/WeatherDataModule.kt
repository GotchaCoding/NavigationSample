package org.techtown.weathersystem.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import org.techtown.weathersystem.WeatherData

@Module
@InstallIn(ActivityComponent::class)
object WeatherDataModule {

    @Provides
    fun provideWeatherData(): WeatherData {
        return WeatherData.getInstance()!!
    }
}