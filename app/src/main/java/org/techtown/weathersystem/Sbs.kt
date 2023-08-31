package org.techtown.weathersystem

class Sbs : Observer {
    var temperature: Int = 0
    var humidity: Int = 0

    override fun update(temperature: Int, humidity: Int) {
        this.temperature = temperature
        this.humidity = humidity
    }


    companion object {
        private var instance: Sbs? = null

        fun getInstance(): Sbs? {
            if (instance == null) {
                instance = Sbs()
            }
            return instance!!
        }
    }
}