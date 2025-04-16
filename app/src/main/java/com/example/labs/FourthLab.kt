package com.example.labs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.labs.ui.theme.LabsTheme
import androidx.navigation.navArgument
import android.content.Context
import android.content.ContextWrapper

class FourthLab : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabsTheme {
                QuizApp()
            }
        }
    }
}

@Composable
fun QuizApp() {
    val navController = rememberNavController()
    val questions = listOf(
        "Its 2025?" to "Yes",
        "1 + 1?" to "2",
        "What color is grass" to "Green"
    )

    val userAnswers = remember { mutableStateListOf(*Array(questions.size) { "" }) }

    NavHost(navController, startDestination = "question/0") {
        composable("question/{index}", arguments = listOf(navArgument("index") { type = NavType.IntType })) { backStackEntry ->
            val index = backStackEntry.arguments?.getInt("index") ?: 0

            QuestionScreen(
                question = questions[index].first,
                answer = userAnswers[index],
                onAnswerChange = { userAnswers[index] = it },
                isFirst = index == 0,
                isLast = index == questions.lastIndex,
                onPrevious = {
                    navController.navigate("question/${index - 1}")
                },
                onNext = {
                    if (index == questions.lastIndex) {
                        navController.navigate("result")
                    } else {
                        navController.navigate("question/${index + 1}")
                    }
                }
            )
        }

        composable("result") {
            val correctAnswers = userAnswers.zip(questions).count {
                it.first.trim().equals(it.second.second, ignoreCase = true)
            }
            val context = LocalContext.current
            ResultScreen(
                correctAnswers = correctAnswers,
                total = questions.size,
                onRetry = {
                    userAnswers.replaceAll { "" }
                    navController.navigate("question/0") {
                        popUpTo("result") { inclusive = true }
                    }
                },
                onExit = {
                    context.findActivity()?.finish()
                }
            )
        }
    }
}

@Composable
fun ResultScreen(correctAnswers: Int, total: Int, onRetry: () -> Unit, onExit: () -> Unit) {
    AlertDialog(
        onDismissRequest = {},
        title = { Text("Result", color = Color.White) },
        text = {
            Text("Correct answers: $correctAnswers from $total", color = Color.White)
        },
        confirmButton = {
            Button(
                onClick = onRetry,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text("Retry")
            }
        },
        dismissButton = {
            Button(
                onClick = onExit,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text("Exit")
            }
        },
        containerColor = Color.DarkGray
    )
}


@Composable
fun QuestionScreen(
    question: String,
    answer: String,
    onAnswerChange: (String) -> Unit,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    isFirst: Boolean,
    isLast: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Quiz", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(24.dp))

        Text(question, color = Color.White, fontSize = 20.sp)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = answer,
            onValueChange = onAnswerChange,
            label = { Text("Your answer", color = Color.White) },
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(color = Color.Black),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Gray
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onPrevious,
                enabled = !isFirst,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.White
                )
            ) {
                Text("Back")
            }

            Button(
                onClick = onNext,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text(if (isLast) "Finish" else "Next")
            }
        }
    }
}


fun Context.findActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

