package com.example.labs

import android.content.Intent
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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource


class SecondLab : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabsTheme {
                secondLab()
            }
        }
    }
}

@Composable

fun secondLab() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(start = 15.dp, end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.nagumo),
            contentDescription = stringResource(R.string.profile_image_desc),
            Modifier.size(size = 150.dp)
        )
        Text (
            modifier = Modifier.padding(top = 15.dp, bottom = 15.dp),
            text = stringResource(R.string.name),
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        Text (
            modifier = Modifier.padding(bottom = 15.dp),
            text = stringResource(R.string.job_title),
            color = Color.White,
            fontSize = 20.sp,
            letterSpacing = 2.sp
        )
        Text (
            text = stringResource(R.string.email),
            color = Color.White
        )
        Text (
            text = stringResource(R.string.phone_number),
            color = Color.White
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