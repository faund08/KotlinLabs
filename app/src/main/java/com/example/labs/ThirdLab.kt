package com.example.labs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource


class ThirdLab : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabsTheme {
                thirdLab()
            }
        }
    }
}

@Composable

fun thirdLab() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.Black)
            .padding(start = 15.dp, end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val images = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, )
        val desc = listOf(R.string.img_desc1, R.string.img_desc2, R.string.img_desc3, R.string.img_desc4, R.string.img_desc5, R.string.img_desc6, R.string.img_desc7)
        var currentIndex by remember { mutableStateOf(0) }

        Image(
            painter = painterResource(id = images[currentIndex]),
            contentDescription = "Switchable image",
            modifier = Modifier
                .width(350.dp)
                .height(500.dp)

        )

        Spacer( modifier = Modifier.height(40.dp))

        Text(text = stringResource(id = desc[currentIndex]),
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.W800)

        Spacer( modifier = Modifier.height(15.dp))

        Row {
            Button(
                onClick = {
                    currentIndex = if (currentIndex > 0) currentIndex - 1 else images.size - 1
                },
                modifier = Modifier.padding(top = 15.dp)
                    .width(150.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            )  {
                Text("PREVIOUS",
                    fontSize = 20.sp)
            }

            Spacer( modifier = Modifier.width(50.dp))

            Button(
                onClick = {
                    currentIndex = (currentIndex + 1) % images.size
                },
                modifier = Modifier.padding(top = 15.dp)
                    .width(150.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text("NEXT",
                    fontSize = 20.sp)
            }

        }

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