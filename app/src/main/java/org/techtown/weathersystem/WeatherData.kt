package org.techtown.weathersystem

class WeatherData : Subject {
    var observers: ArrayList<Observer> = arrayListOf()
    var temperature: Int = 0
    var humidity: Int = 0

    var isRegisterObservers : Boolean = false


    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun unremoveObserver(o: Observer) {
        val num = observers.indexOf(o)
        if (num >= 0) {
            observers.removeAt(num)
        }
    }

    override fun notifyObserver() {
        for (i in 0 until observers.size) {
            val observer: Observer = observers[i]
            observer.update(temperature, humidity)
        }
    }

    fun mesurementsChanged() {
        notifyObserver()
    }

    fun setMeasurements(temperature: Int, humidity: Int) {
        this.temperature = temperature
        this.humidity = humidity

        mesurementsChanged()
    }

    fun setTempChanged(temperature: Int){
        this.temperature = temperature
        mesurementsChanged()
    }

    fun setHumidityChanged(humidity: Int){
        this.humidity = humidity
        mesurementsChanged()
    }
    companion object {
        private var instance: WeatherData? = null

        fun getInstance(): WeatherData? {
            if (instance == null) {
                instance = WeatherData()
            }
            return instance!!
        }
    }


}