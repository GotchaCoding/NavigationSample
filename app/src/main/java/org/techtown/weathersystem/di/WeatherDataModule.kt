package org.techtown.weathersystem.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import org.techtown.weathersystem.Sbs
import org.techtown.weathersystem.SbsImpl
import org.techtown.weathersystem.WeatherData
import javax.inject.Singleton

@Module
@InstallIn( SingletonComponent::class)
object WeatherDataModule {

    @Provides
    @Singleton
    fun provideWeatherData(): WeatherData {
        return WeatherData()
    }

    @Provides
    @Singleton
    fun provideSbs(): Sbs {   // SBS 는 내가 만든 클래스이므로 Binds가 맞는거 같은데 이거 되네. 바인드로 사용하려면 인터페이스 형식으로 해야하긴 하는데..
                               //Provides는 외부라이브러리이거나 객체를 빌더패턴으로 생성하는경우 사용
        return SbsImpl()
    }



}