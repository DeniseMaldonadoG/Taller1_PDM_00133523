package com.pdm0126.taller1_00133523.ui.theme
import androidx.compose.runtime.saveable.listSaver

data class QuizState(
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val totalQuestions: Int = 3,
    val isQuizStarted: Boolean = false,
    val isAnswered: Boolean = false,
    val selectedAnswerIndex: Int? = null,
    val showFunFact: Boolean = false,
    val isQuizFinished: Boolean = false
){
    companion object {

        val Saver = listSaver(
            save = {
                listOf(
                    it.currentQuestionIndex,
                    it.score,
                    it.totalQuestions,
                    it.isQuizStarted,
                    it.isAnswered,
                    it.selectedAnswerIndex,
                    it.showFunFact,
                    it.isQuizFinished
                )
            },

            restore = {
                QuizState(
                    currentQuestionIndex = it[0] as Int,
                    score = it[1] as Int,
                    totalQuestions = it[2] as Int,
                    isQuizStarted = it[3] as Boolean,
                    isAnswered = it[4] as Boolean,
                    selectedAnswerIndex = it[5] as Int?,
                    showFunFact = it[6] as Boolean,
                    isQuizFinished = it[7] as Boolean
                )
            }
        )
    }
}
