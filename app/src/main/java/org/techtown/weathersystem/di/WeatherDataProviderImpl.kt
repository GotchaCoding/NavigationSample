package org.techtown.weathersystem.di

import org.techtown.weathersystem.WeatherData

object WeatherDataProviderImpl : WeatherDataProvider {
    private val weatherData: WeatherData = WeatherData.getInstance()!!
    override fun provideWeatherData(): WeatherData {
        return weatherData
    }
}