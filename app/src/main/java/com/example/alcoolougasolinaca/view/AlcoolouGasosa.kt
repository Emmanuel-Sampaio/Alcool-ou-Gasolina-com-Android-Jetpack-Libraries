package com.example.alcoolougasolinaca.view

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.alcoolougasolinaca.view.MainViewModel
import androidx.compose.ui.Alignment


@Composable
fun AlcoolOuGasosaScreen(
    activity: Activity,
    viewModel: MainViewModel = viewModel()
) {
    val nomePosto = viewModel.nomePosto.value
    val precoAlcool = viewModel.precoAlcool.value
    val precoGasolina = viewModel.precoGasolina.value
    val resultado = viewModel.resultado.value

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.8f), // largura reduzida pra ficar mais centralizado e visual agradável
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                value = nomePosto,
                onValueChange = { viewModel.atualizarNomePosto(it) },
                label = { Text("Nome do Posto") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = precoAlcool,
                onValueChange = { viewModel.atualizarAlcool(it) },
                label = { Text("Preço do Álcool") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = precoGasolina,
                onValueChange = { viewModel.atualizarGasolina(it) },
                label = { Text("Preço da Gasolina") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = { viewModel.calcularMelhorOpcao() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calcular")
            }

            Text(
                text = resultado,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}
