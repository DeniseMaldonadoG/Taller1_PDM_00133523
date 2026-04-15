package com.pdm0126.taller1_00133523.ui.theme

data class QuizState(
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val totalQuestions: Int = 3,
    val isQuizStarted: Boolean = false,
    val isAnswered: Boolean = false,
    val selectedAnswerIndex: Int? = null,
    val showFunFact: Boolean = false,
    val isQuizFinished: Boolean = false
)