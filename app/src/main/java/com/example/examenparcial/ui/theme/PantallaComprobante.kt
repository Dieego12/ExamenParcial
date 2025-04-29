package com.example.examenparcial.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PantallaComprobante(montoRetirado: String, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("¡Retiro exitoso!", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))
        Text("Has retirado: $${montoRetirado}", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            navController.popBackStack() //
        }) {
            Text("Volver")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPantallaComprobante() {
    MaterialTheme {
        PantallaComprobante(montoRetirado = "150.0", navController = rememberNavController())
    }
}