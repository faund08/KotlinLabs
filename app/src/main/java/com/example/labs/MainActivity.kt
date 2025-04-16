package com.example.labs

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.labs.ui.theme.LabsTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabsTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize()
        .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            val intent = Intent(context, FirstLab::class.java)
            context.startActivity(intent)
        },
            modifier = Modifier
                .width(350.dp)
                .height(75.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text("First lab", fontSize = 35.sp,)
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            val intent = Intent(context, SecondLab::class.java)
            context.startActivity(intent)
        },
            modifier = Modifier
                .width(350.dp)
                .height(75.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text("Second lab", fontSize = 35.sp,)
        }
        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            val intent = Intent(context, ThirdLab::class.java)
            context.startActivity(intent)
        },
            modifier = Modifier
                .width(350.dp)
                .height(75.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text("Third lab", fontSize = 35.sp,)
        }
        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            val intent = Intent(context, FourthLab::class.java)
            context.startActivity(intent)
        },
            modifier = Modifier
                .width(350.dp)
                .height(75.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text("Fourth/Fifth lab", fontSize = 35.sp,)
        }
        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            val intent = Intent(context, Lab6Screen::class.java)
            context.startActivity(intent)
        },
            modifier = Modifier
                .width(350.dp)
                .height(75.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Text("Sixth lab", fontSize = 35.sp,)
        }
    }
}
