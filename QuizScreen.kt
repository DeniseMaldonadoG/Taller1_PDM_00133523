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
fun QuizScreen(
    quizState: QuizState,
    quizQuestions: List<Question>,
    onAnswerSelected: (Int) -> Unit,
    onNextQuestion: () -> Unit
) {
    val currentQuestion = quizQuestions[quizState.currentQuestionIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Pregunta ${quizState.currentQuestionIndex + 1} de ${quizState.totalQuestions}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Puntaje: ${quizState.score} / ${quizState.totalQuestions}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Card de pregunta
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = currentQuestion.question,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Medium
                )
            }
        }


        Column {
            currentQuestion.options.forEachIndexed { index, option ->
                val isCorrect = index == currentQuestion.correctAnswerIndex
                val isSelected = quizState.selectedAnswerIndex == index
                val isAnswered = quizState.isAnswered

                Button(
                    onClick = {
                        if (!isAnswered) {
                            onAnswerSelected(index)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    enabled = !isAnswered,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = when {
                            isAnswered && isCorrect -> MaterialTheme.colorScheme.primary
                            isAnswered && isSelected && !isCorrect -> MaterialTheme.colorScheme.error
                            else -> MaterialTheme.colorScheme.surfaceVariant
                        }
                    )
                ) {
                    Text(option)
                }
            }
        }

        if (quizState.showFunFact) {
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "💡 Fun Fact",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = currentQuestion.funFact,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        // botton
        Spacer(modifier = Modifier.height(24.dp))
        val buttonText = if (quizState.currentQuestionIndex == 2) "Ver Resultado" else "Siguiente"
        Button(
            onClick = onNextQuestion,
            modifier = Modifier.fillMaxWidth(),
            enabled = quizState.isAnswered
        ) {
            Text(buttonText, fontSize = 18.sp)
        }
    }
}