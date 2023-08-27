package org.techtown.weathersystem

interface Subject {
    fun registerObserver(o: Observer)
    fun unremoveObserver(o: Observer)
    fun notifyObserver()
}