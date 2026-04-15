package com.pdm0126.taller1_00133523

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.pdm0126.taller1_00133523.ui.theme.AndroidPediaByMaldonadoTheme
import com.pdm0126.taller1_00133523.ui.theme.QuizState

import com.pdm0126.taller1_00133523.ui.theme.WelcomeScreen
import com.pdm0126.taller1_00133523.ui.theme.ResultScreen
import com.pdm0126.taller1_00133523.ui.theme.QuizScreen
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.pdm0126.taller1_00133523.ui.theme.quizQuestions



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPediaByMaldonadoTheme {
                AndroidPediaApp()
            }
        }
    }
}

@Composable
fun AndroidPediaApp() {
    var quizState by remember { mutableStateOf(QuizState()) }

    if (!quizState.isQuizStarted) {
        WelcomeScreen(
            studentName = "Gabriela Maldonado",
            studentId = "00133523",
            onStartQuiz = { quizState = quizState.copy(isQuizStarted = true) }
        )
    } else if (!quizState.isQuizFinished) {
        QuizScreen(
            quizState = quizState,
            quizQuestions = quizQuestions,
            onAnswerSelected = { selectedIndex ->
                val currentQuestion = quizQuestions[quizState.currentQuestionIndex]
                val isCorrect = selectedIndex == currentQuestion.correctAnswerIndex

                quizState = quizState.copy(
                    isAnswered = true,
                    selectedAnswerIndex = selectedIndex,
                    score = if (isCorrect) quizState.score + 1 else quizState.score,
                    showFunFact = true
                )
            },
            onNextQuestion = {
                if (quizState.currentQuestionIndex < quizState.totalQuestions - 1) {
                    quizState = quizState.copy(
                        currentQuestionIndex = quizState.currentQuestionIndex + 1,
                        isAnswered = false,
                        selectedAnswerIndex = null,
                        showFunFact = false
                    )
                } else {
                    quizState = quizState.copy(isQuizFinished = true)
                }
            }
        )
    } else {
        ResultScreen(
            finalScore = quizState.score,
            onRestart = {
                quizState = QuizState()
            }
        )
    }
}
