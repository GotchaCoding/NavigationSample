package org.techtown.weathersystem.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.techtown.weathersystem.Jtbc
import org.techtown.weathersystem.Kbs
import org.techtown.weathersystem.R
import org.techtown.weathersystem.Sbs
import org.techtown.weathersystem.WeatherData
import org.techtown.weathersystem.databinding.FragmentHomeBinding
import org.techtown.weathersystem.di.WeatherDataProvider
import org.techtown.weathersystem.di.WeatherDataProviderImpl

class Home : Fragment() {

    private var _binidng: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binidng!!

//    private var weatherData: WeatherData = WeatherData.getInstance()!!

    private val weatherDataProvider : WeatherDataProvider = WeatherDataProviderImpl
    private var weatherData : WeatherData = weatherDataProvider.provideWeatherData()

    private var isRegisterObservers : Boolean = false

    val kbs: Kbs = Kbs()
    val sbs: Sbs = Sbs()
    val jtbc: Jtbc = Jtbc()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binidng = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        initView()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(!isRegisterObservers) {
            registerObservers()    //옵저버 등록은 최초 한번만 실행
            isRegisterObservers = true
        }

        binding.apply{
            temperature.text = sbs.temperature.toString()
            humidity.text = sbs.humidity.toString()
            temperature2.text = kbs.temperature.toString()
            humidity2.text = kbs.humidity.toString()
            temperature3.text = jtbc.temperature.toString()
            humidity3.text = jtbc.humidity.toString()
        }

    }

    fun initView(){
        binding.apply{
            imgSbs.setImageResource(R.drawable.img_sbs)
            imgKbs.setImageResource(R.drawable.img_kbs)
            imgJtbc.setImageResource(R.drawable.img_jtbc)
            imgSbs.clipToOutline = true
            imgKbs.clipToOutline = true
            imgJtbc.clipToOutline = true
        }

        binding.apply {
            btnRemoveSbs.setOnClickListener {
                unremoveObserverSbs()
                Toast.makeText(context, "옵저버 해제", Toast.LENGTH_SHORT).show()
            }
            btnRemoveKbs.setOnClickListener {
                unremoveObserverKbs()
                Toast.makeText(context, "옵저버 해제", Toast.LENGTH_SHORT).show()
            }
            btnRemoveJtbc.setOnClickListener {
                unremoveObserverJtbc()
                Toast.makeText(context, "옵저버 해제", Toast.LENGTH_SHORT).show()
            }
            btnRegisterSbs.setOnClickListener {
                registerObserverSbs()
                Toast.makeText(context, "옵저버 등록", Toast.LENGTH_SHORT).show()
            }
            btnRegisterKbs.setOnClickListener {
                registerObserverKbs()
                Toast.makeText(context, "옵저버 등록", Toast.LENGTH_SHORT).show()
            }
            btnRegisterJtbc.setOnClickListener {
                registerObserverJtbc()
                Toast.makeText(context, "옵저버 등록", Toast.LENGTH_SHORT).show()
            }



        }
    }
    private fun registerObservers() {
        weatherData.registerObserver(kbs)
        weatherData.registerObserver(sbs)
        weatherData.registerObserver(jtbc)
    }

    override fun onDestroy() {
        unremoveObservers()
        super.onDestroy()
    }

    private fun unremoveObservers() {
        weatherData.unremoveObserver(kbs)
        weatherData.unremoveObserver(sbs)
        weatherData.unremoveObserver(jtbc)
    }

    private fun unremoveObserverSbs() {
        weatherData.unremoveObserver(sbs)
    }

    private fun unremoveObserverKbs() {
        weatherData.unremoveObserver(kbs)
    }

    private fun unremoveObserverJtbc() {
        weatherData.unremoveObserver(jtbc)
    }

    private fun registerObserverSbs() {
        weatherData.registerObserver(sbs)
    }

    private fun registerObserverKbs() {
        weatherData.registerObserver(kbs)
    }

    private fun registerObserverJtbc() {
        weatherData.registerObserver(jtbc)
    }


}