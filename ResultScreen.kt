package com.pdm0126.taller1_00133523.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ResultScreen(
    finalScore: Int,
    onRestart: () -> Unit
) {
    val message = when {
        finalScore == 3 -> "¡Excelente! Eres un verdadero experto en Android"
        finalScore == 2 -> "¡Muy bien! Tienes buen conocimiento de Android"
        finalScore == 1 -> "No está mal, pero practica más"
        else -> "¡Sigue estudiando! Aún hay mucho por aprender"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "¡Quiz Finalizado!",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Obtuviste $finalScore de 3",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = onRestart,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reiniciar Quiz", fontSize = 18.sp)
        }
    }
}
