package org.techtown.weathersystem

interface Observer {
    fun update(temperature: Int, humidity: Int)
}
