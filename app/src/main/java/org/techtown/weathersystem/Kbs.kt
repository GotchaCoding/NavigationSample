package org.techtown.weathersystem

class Kbs : Observer {
    var temperature: Int = 0
    var humidity: Int = 0

    override fun update(temperature: Int, humidity: Int) {
        this.temperature = temperature
        this.humidity = humidity
    }


    companion object {
        private var instance: Kbs? = null

        fun getInstance(): Kbs? {
            if (instance == null) {
                instance = Kbs()
            }
            return instance!!
        }
    }
}