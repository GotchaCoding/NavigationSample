package org.techtown.weathersystem.di.kbs

import org.techtown.weathersystem.Kbs

object KbsProviderImpl : KbsProvider{
    override fun provideKbs(): Kbs {
        return Kbs.getInstance()!!
    }
}