package com.example.foodapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Image(painter = painterResource(id = R.drawable.front), contentDescription = null, modifier = Modifier
            .fillMaxSize()
            .alpha(0.7f), contentScale = ContentScale.Crop)
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome", modifier = Modifier.padding(32.dp), fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold, fontSize = 64.sp, color = Color.White)
        Spacer(modifier = Modifier.padding(64.dp))
        var name by remember { mutableStateOf("") }
        var pass by remember { mutableStateOf("") }
        TextField(value = name, onValueChange = {it-> name = it}, label = {Text("Username", color = Color.Red)}, colors = TextFieldDefaults.textFieldColors(textColor = Color.Black))
        TextField(value = pass, onValueChange = {it-> pass = it}, label = {Text("Password", color = Color.Red)}, colors = TextFieldDefaults.textFieldColors(textColor = Color.Black), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done), visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.padding(64.dp))
        Button(onClick = { navController.navigate("hotel") }, colors = ButtonDefaults.buttonColors(Color.Red)) {
            Text(text = "Login")
        }
    }
}
