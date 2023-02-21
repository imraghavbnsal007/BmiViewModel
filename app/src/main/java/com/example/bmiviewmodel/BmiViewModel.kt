package com.example.bmiviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel: ViewModel() {
    var HeightInput by mutableStateOf("")
    var WeightINput by mutableStateOf("")

    var bmi: Float = 0.0f
        get() {
            return calculate()
        }

    fun changeHeight(value: String) {
        HeightInput = value
    }

    fun changeWeight (value: String) {
        WeightINput = value
    }
    private var height: Float = 0.0f
        get() {
            return HeightInput.toFloatOrNull() ?: 0.0f
        }

    private var weight: Int = 0
        get() {
            return WeightINput.toIntOrNull() ?:0
        }


    private fun calculate(): Float {
        return if (weight > 0 && height > 0) weight / (height * height) else 0.0f
    }

}