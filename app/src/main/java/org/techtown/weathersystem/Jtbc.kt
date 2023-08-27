package org.techtown.weathersystem

class Jtbc() : Observer {
    var temperature: Int = 0
    var humidity: Int = 0


    override fun update(temperature: Int, humidity: Int) {
        this.temperature = temperature
        this.humidity = humidity
    }

}