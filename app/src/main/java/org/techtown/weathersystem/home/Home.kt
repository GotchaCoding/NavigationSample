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

class Home : Fragment() {

    private var _binidng: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binidng!!

    private var weatherData: WeatherData = WeatherData.getInstance()!!

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
        registerObservers()

        binding.apply{
            temperature.text = sbs.temperature.toString()
            humidity.text = sbs.humidity.toString()
            temperature2.text = sbs.temperature.toString()
            humidity2.text = sbs.humidity.toString()
            temperature3.text = sbs.temperature.toString()
            humidity3.text = sbs.humidity.toString()

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
                Toast.makeText(context, "옵저버 해제", Toast.LENGTH_LONG).show()
            }
            btnRemoveKbs.setOnClickListener {
                unremoveObserverKbs()
                Toast.makeText(context, "옵저버 해제", Toast.LENGTH_LONG).show()
            }
            btnRemoveJtbc.setOnClickListener {
                unremoveObserverJtbc()
                Toast.makeText(context, "옵저버 해제", Toast.LENGTH_LONG).show()
            }
            btnRegisterSbs.setOnClickListener {
                registerObserverSbs()
                Toast.makeText(context, "옵저버 등록", Toast.LENGTH_LONG).show()
            }
            btnRegisterKbs.setOnClickListener {
                registerObserverKbs()
                Toast.makeText(context, "옵저버 등록", Toast.LENGTH_LONG).show()
            }
            btnRegisterJtbc.setOnClickListener {
                registerObserverJtbc()
                Toast.makeText(context, "옵저버 등록", Toast.LENGTH_LONG).show()
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