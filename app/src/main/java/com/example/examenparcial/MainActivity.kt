package com.example.examenparcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examenparcial.ui.theme.PantallaBilletera
import com.example.examenparcial.ui.theme.PantallaComprobante

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BilleteraApp()
            }
        }
    }
}

@Composable
fun BilleteraApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "billetera") {
        composable("billetera") {
            PantallaBilletera(navController)
        }
        composable("comprobante/{montoRetirado}") { backStackEntry ->
            val montoRetirado = backStackEntry.arguments?.getString("montoRetirado") ?: "0"
            PantallaComprobante(montoRetirado, navController)
        }
    }
}



