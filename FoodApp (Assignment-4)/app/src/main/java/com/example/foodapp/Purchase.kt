package com.example.foodapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
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
fun Purchase(navController: NavController) {
    var success by remember { mutableStateOf(false) }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Image(painter = painterResource(id = purchase.poster), contentDescription = purchase.title, modifier = Modifier
            .fillMaxSize()
            .alpha(0.5f), contentScale = ContentScale.Crop)
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Purchasing", modifier = Modifier.padding(64.dp), fontSize = 64.sp, fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold, color = Color.Cyan)
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(64.dp), horizontalArrangement = Arrangement.Center) {
            Text(purchase.title, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.padding(start = 64.dp, end = 64.dp))
            Text("₹"+purchase.price, fontWeight = FontWeight.Bold, color = Color.White)
        }
        Button(onClick = {success = true}, modifier = Modifier.padding(64.dp), colors = ButtonDefaults.buttonColors(Color.Red)) {
            Text("Purchase")
        }
        if(success) {
            Snackbar(modifier = Modifier.padding(16.dp), action = {
                TextButton(onClick = { success = false }) {
                    Text("Close")
                }
            }) {
                Text(text = "Your Purchase is Successful")
            }
        }
    }
}