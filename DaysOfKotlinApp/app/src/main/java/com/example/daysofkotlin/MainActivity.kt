package com.example.daysofkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.daysofkotlin.ui.theme.DaysOfKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaysOfKotlinTheme {
                // A surface container using the 'background' color from the theme
                DaysOfKotlinApp()
            }
        }
    }
}