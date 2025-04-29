package com.example.examenparcial.ui.theme

import ads_mobile_sdk.h5
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("DefaultLocale")
@Composable
fun PantallaBilletera(navController: NavHostController) {
    var saldo by remember { mutableStateOf(10000.0) }
    var retiroTexto by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Saldo actual: $${String.format("%.2f", saldo)}", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = retiroTexto,
            onValueChange = { retiroTexto = it },
            label = { Text("Monto a retirar") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val monto = retiroTexto.toDoubleOrNull()
            if (monto != null && monto <= saldo) {
                saldo =- monto
                error = false
                navController.navigate("comprobante/${monto}")
            } else {
                error = true
            }
        }) {
            Text("Retirar")
        }

        if (error) {
            Spacer(modifier = Modifier.height(10.dp))
            Text("Monto inválido o superior al saldo disponible", color = MaterialTheme.colorScheme.error)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPantallaBilletera() {
    MaterialTheme {
        PantallaBilletera(navController = rememberNavController())
    }
}



