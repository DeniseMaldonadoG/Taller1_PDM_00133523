package com.pdm0126.taller1_00133523.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(
    studentName: String,
    studentId: String,
    onStartQuiz: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "AndroidPedia",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "¿Cuánto sabes de Android?",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Creado por:",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "$studentName - $studentId",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = onStartQuiz,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Comenzar Quiz", fontSize = 18.sp)
        }
    }
}