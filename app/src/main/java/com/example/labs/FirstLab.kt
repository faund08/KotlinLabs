package com.example.labs

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.labs.ui.theme.LabsTheme
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.platform.LocalContext



class FirstLab : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabsTheme {
                firstLab()
            }
        }
    }
}

@Composable

fun firstLab() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.Black)
            .padding(start = 15.dp, end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Структура проєкту в Android Studio \n\n", fontSize = 21.sp,
            color = Color.White,
            fontWeight = FontWeight.W900)
        Text("1. Встановити останню версію Android Studio, чи оновити вже встановлену. \n" +
                "\n" +
                "2. Створити новий проєкт на мові Kotlin (Empty Activity).\n" +
                "\n" +
                "3. Переглянути структуру проєкту. \n" +
                "4. Створити емулятор у вікні Device Manager. Обрати тип пристрою та актуальну версію SDK. Запустити проєкт (Run) та переконатися, що він працює в емуляторі.Як варіант, можна застосовувати реальний Android-смартфон, підключений до ПК.\n" +
                "\n" +
                "5. Переглянути попередній перегляд (секція @Preview) Composable-функції (натиснувши кнопку Split).",
            color = Color.White,
            fontSize = 12.sp,
            )
        val context = LocalContext.current

        Button(onClick = {

            (context as? ComponentActivity)?.finish()
        },
            modifier = Modifier.padding(top = 50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text("Home 🏠",
                Modifier.padding(start = 50.dp, top = 15.dp, end = 50.dp, bottom = 15.dp),
                fontSize = 35.sp)
        }
    }
}
