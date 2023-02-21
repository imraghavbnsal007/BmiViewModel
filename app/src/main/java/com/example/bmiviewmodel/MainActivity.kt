package com.example.bmiviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmiviewmodel.ui.theme.BMIviewmodelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMIviewmodelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BMI()
                }
            }
        }
    }
}

@Composable
fun BMI(bmiViewModel: BmiViewModel = viewModel())
{
    Column{
        Text(
            text = "Body Mass Index",
            fontSize = 40.sp,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            label = { Text(text = stringResource(com.example.bmiviewmodel.R.string.height))},
            value = bmiViewModel.HeightInput,
            onValueChange = {bmiViewModel.changeHeight(it)},
            singleLine = true,
            keyboardOptions = KeyboardOptions (keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding()
        )
        OutlinedTextField(
            label = { Text(text = stringResource(com.example.bmiviewmodel.R.string.weight))},
            value = bmiViewModel.WeightINput,
            onValueChange = {bmiViewModel.changeWeight(it)},
            singleLine = true,
            keyboardOptions = KeyboardOptions (keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding()
        )
        Text(
            text = stringResource(com.example.bmiviewmodel.R.string.body_mass_index, bmiViewModel.bmi)
        )



    }

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BMIviewmodelTheme {
        BMI()

    }
}

