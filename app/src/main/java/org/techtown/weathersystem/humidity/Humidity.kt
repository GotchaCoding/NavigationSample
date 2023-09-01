package org.techtown.weathersystem.humidity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.techtown.weathersystem.R
import org.techtown.weathersystem.WeatherData
import org.techtown.weathersystem.databinding.FragmentHumidityBinding
import javax.inject.Inject

@AndroidEntryPoint
class Humidity : Fragment() {
    @Inject
    lateinit var weatherData: WeatherData

    private var _binidng: FragmentHumidityBinding? = null
    private val binding: FragmentHumidityBinding
        get() = _binidng!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binidng = DataBindingUtil.inflate(inflater, R.layout.fragment_humidity, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnHumidity.setOnClickListener {
                val resultNum = edtHumidity.text.toString().toInt()
                weatherData.setHumidityChanged(resultNum)
            }
        }
    }
}