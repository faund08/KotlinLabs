package com.example.labs.ui.theme

import androidx.compose.foundation.background
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImage
import com.example.labs.data.model.ImageItem
import com.example.labs.data.network.ApiService
import com.example.labs.data.repository.ImageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.platform.LocalContext

class ImageListViewModel : ViewModel() {
    private val apiService = Retrofit.Builder()
        .baseUrl("https://picsum.photos/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    private val repository = ImageRepository(apiService)

    private val _images = MutableStateFlow<List<ImageItem>>(emptyList())
    val images: StateFlow<List<ImageItem>> = _images

    init {
        viewModelScope.launch {
            _images.value = repository.fetchImages()
        }
    }
}

@Composable
fun ImageListScreen(viewModel: ImageListViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val images by viewModel.images.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.Black),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(images.size) { index ->
            val item = images[index]
            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                Text(text = item.author, style = MaterialTheme.typography.titleMedium, color = Color.White)
                AsyncImage(
                    model = item.download_url,
                    contentDescription = item.author,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
        }

        item {
            val context = LocalContext.current

            Button(
                onClick = {
                    (context as? ComponentActivity)?.finish()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text(
                    "Home 🏠",
                    Modifier.padding(start = 50.dp, top = 15.dp, end = 50.dp, bottom = 15.dp),
                    fontSize = 35.sp
                )
            }
        }
    }

}
