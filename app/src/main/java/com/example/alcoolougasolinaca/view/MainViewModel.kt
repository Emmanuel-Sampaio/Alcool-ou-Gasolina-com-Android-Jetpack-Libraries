package com.example.alcoolougasolinaca.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var nomePosto = mutableStateOf("")
        private set

    var precoAlcool = mutableStateOf("")
        private set

    var precoGasolina = mutableStateOf("")
        private set

    var resultado = mutableStateOf("")
        private set

    fun atualizarNomePosto(valor: String) {
        nomePosto.value = valor
    }

    fun atualizarAlcool(valor: String) {
        precoAlcool.value = valor
    }

    fun atualizarGasolina(valor: String) {
        precoGasolina.value = valor
    }

    fun calcularMelhorOpcao() {
        val alcool = precoAlcool.value.toFloatOrNull()
        val gasolina = precoGasolina.value.toFloatOrNull()

        resultado.value = when {
            alcool == null || gasolina == null -> "Preços inválidos"
            alcool / gasolina < 0.7 -> "Melhor usar Álcool"
            else -> "Melhor usar Gasolina"
        }
    }
}
