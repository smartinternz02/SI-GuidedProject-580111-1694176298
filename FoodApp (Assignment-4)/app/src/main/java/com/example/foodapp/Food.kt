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

@Composable
fun Food(navController: NavController) {
    var temp: List<food> = foods[selected] ?: listOf()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Image(painter = painterResource(id = R.drawable.pattern), contentDescription = null, modifier = Modifier
            .fillMaxSize()
            .alpha(0.5f), contentScale = ContentScale.Crop)
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Foods", modifier = Modifier.padding(16.dp), fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold, fontSize = 64.sp, color = Color.White)
        Spacer(modifier = Modifier.padding(16.dp))
        LazyColumn {
            items(temp) { it -> eachcard_food(navController, food = it)}
        }
    }
}

data class food(val title: String, val poster: Int, val price: Int)

val foods = mapOf<String, List<food>> (
    "STAR Hotel" to listOf(
        food("Pizza", R.drawable.pizza, 135),
        food("Biryani", R.drawable.biryani, 245),
        food("Soft drink", R.drawable.soft_drink, 20),
        food("Lassi", R.drawable.lassi, 20),
        food("Chicken", R.drawable.chicken, 185)
    ),
    "ALFA Restaurant" to listOf(
        food("Coffee", R.drawable.coffee, 25),
        food("Soft drink", R.drawable.soft_drink, 20),
        food("Burger", R.drawable.burger, 125),
        food("Pop Corn", R.drawable.pop_corn, 40),
        food("Ice Cream", R.drawable.ice_cream, 30)
    ),
    "GRILLS and GIBBS" to listOf(
        food("Fish", R.drawable.fish, 70),
        food("Soft Drink", R.drawable.soft_drink, 20),
        food("Biryani", R.drawable.biryani, 255),
        food("Tiffin", R.drawable.tiffin, 35),
        food("Roti", R.drawable.roti, 45)
    ),
    "GREAT INDIA HOTEL" to listOf(
        food("Pizza", R.drawable.pizza, 175),
        food("Chicken", R.drawable.chicken, 215),
        food("Burger", R.drawable.burger, 120),
        food("Soft Drink", R.drawable.soft_drink, 20),
        food("Fish Fry", R.drawable.fish, 130)
    ),
    "FRIENDS FOODS" to listOf(
        food("Coffee", R.drawable.coffee, 30),
        food("Roti", R.drawable.roti, 25),
        food("Tiffin", R.drawable.tiffin, 50),
        food("Pizza", R.drawable.pizza, 99),
        food("Burger", R.drawable.burger, 150),
        food("Pop Corn", R.drawable.pop_corn, 45),
        food("Parota", R.drawable.roti, 25)
    )
)

@Composable
fun eachcard_food(navController: NavController, food: food) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .clickable { purchase = food; navController.navigate("purchase") }) {
        Column {
            Image(
                painter = painterResource(id = food.poster),
                contentDescription = food.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    food.title,
                    modifier = Modifier.padding(2.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.padding(start = 64.dp, end = 64.dp))
                Text(
                    "₹" + food.price,
                    modifier = Modifier.padding(2.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}

var purchase: food = food("", 0, 0)