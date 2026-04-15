package com.pdm0126.taller1_00133523.ui.theme

data class Question(//no se ocupa id debido a que no se usa ninguna BD ni se busca por id
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val funFact: String
)

val quizQuestions = listOf(

Question(
    question = "¿Cuál fue el impacto de Android en la industria de los smartphones?",
    options = listOf("Lidero el mercado de celulares a nivel global", "Se enfoco solo en camaras digitales", "Fracaso con Google", "Logro que Apple liderara el mercado"),
    correctAnswerIndex = 0,
    funFact = "Su adopción masiva llevó a una disminución de precios en celulares inteligentes"
),

    Question(
        question = "¿Qué organización lanzó la Open Handset Alliance?",
        options = listOf("Apple", "Oracle", "Google", "Microsoft"),
        correctAnswerIndex = 2,
        funFact = "La alianza incluye a importantes empresas tecnológicas, lo que ha permitido a Android convertirse en el sistema operativo más utilizado en el mundo."
    ),

    Question(
        question = "¿En qué año la Corte Suprema falló a favor de Google en el caso de Oracle?",
        options = listOf("2015", "2003", "2011", "2021"),
        correctAnswerIndex = 3,
        funFact = "La decisión de la Corte Suprema fue un hito importante para la industria tecnológica, afectando el desarrollo de software y la innovacion"
    ),

)