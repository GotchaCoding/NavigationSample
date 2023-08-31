package org.techtown.weathersystem.di.kbs

import org.techtown.weathersystem.Kbs

interface KbsProvider {
    fun provideKbs() : Kbs
}