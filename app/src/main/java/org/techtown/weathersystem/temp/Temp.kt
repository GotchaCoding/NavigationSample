package org.techtown.weathersystem.temp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.techtown.weathersystem.R
import org.techtown.weathersystem.WeatherData
import org.techtown.weathersystem.databinding.FragmentTempBinding
import org.techtown.weathersystem.di.WeatherDataProvider
import javax.inject.Inject

@AndroidEntryPoint
class Temp : Fragment() {

    @Inject
    lateinit var weatherData: WeatherData

    private var _binidng: FragmentTempBinding? = null
    private val binding: FragmentTempBinding
        get() = _binidng!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binidng = DataBindingUtil.inflate(inflater, R.layout.fragment_temp, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
//            val resultNum = edtTemp.toString().toInt()

            btnTemp.setOnClickListener {
                val resultNum = edtTemp.text.toString().toInt()
                weatherData.setTempChanged(resultNum)

                it.findNavController().navigate(R.id.action_temp_to_home)
//                it.findNavController().navigate(TempDirections.actionTempToHome(1))
            }
        }
    }

    fun sendArg(){
//        Temp
    }
}