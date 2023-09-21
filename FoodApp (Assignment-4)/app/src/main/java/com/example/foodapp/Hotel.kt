package com.example.foodapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.mlkit.vision.text.Text

@Composable
fun Hotel(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Image(painter = painterResource(id = R.drawable.pattern), contentDescription = null, modifier = Modifier
            .fillMaxSize()
            .alpha(0.5f), contentScale = ContentScale.Crop)
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Hotels", modifier = Modifier.padding(16.dp), fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold, fontSize = 64.sp, color = Color.LightGray)
        Spacer(modifier = Modifier.padding(16.dp))
        LazyColumn {
            items(hotels) {it -> eachcard_hotel(navController, hotel = it)}
        }
    }
}

data class hotel(val title: String, val poster: Int)

val hotels = listOf(
    hotel("STAR Hotel", R.drawable.hotel_1),
    hotel("ALFA Restaurant", R.drawable.hotel_2),
    hotel("GRILLS and GIBBS", R.drawable.hotel_3),
    hotel("GREAT INDIA Hotel", R.drawable.hotel_4),
    hotel("FRIENDS Foods", R.drawable.hotel_5)
)

@Composable
fun eachcard_hotel(navController: NavController, hotel: hotel) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .clickable { selected = hotel.title; navController.navigate("food") }) {
        Image(painter = painterResource(id = hotel.poster), contentDescription = hotel.title, modifier = Modifier
            .fillMaxWidth()
            .height(200.dp), contentScale = ContentScale.Crop)
        Text(hotel.title, modifier = Modifier.padding(2.dp), fontWeight = FontWeight.Bold)
    }
}

var selected: String = ""