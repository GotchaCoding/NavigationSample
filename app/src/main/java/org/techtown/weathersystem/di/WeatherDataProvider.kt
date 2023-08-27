package org.techtown.weathersystem.di

import org.techtown.weathersystem.WeatherData

interface WeatherDataProvider {
    fun provideWeatherData() : WeatherData
}