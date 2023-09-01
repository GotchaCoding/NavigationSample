package org.techtown.weathersystem

import javax.inject.Inject

class KbsImpl @Inject constructor() : Observer, Kbs {
    override var temperature: Int = 0
    override var humidity: Int = 0

    override fun update(temperature: Int, humidity: Int) {
        this.temperature = temperature
        this.humidity = humidity
    }

}

interface Kbs : Observer {
    var temperature: Int
    var humidity: Int
}