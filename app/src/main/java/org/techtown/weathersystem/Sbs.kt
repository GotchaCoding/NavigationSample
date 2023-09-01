package org.techtown.weathersystem

class SbsImpl : Sbs {
    override var temperature: Int = 0
    override var humidity: Int = 0

    override fun update(temperature: Int, humidity: Int) {
        this.temperature = temperature
        this.humidity = humidity
    }

}

interface Sbs : Observer {
    var temperature: Int
    var humidity: Int

}