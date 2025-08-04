package com.example.alcoolougasolinaca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.alcoolougasolinaca.view.AlcoolOuGasosaScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlcoolOuGasosaScreen(activity = this)
        }
    }
}
