package com.mesh.pay.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mesh.pay.R
import com.mesh.pay.ui.theme.Blue_medium

/**
 * T
 */
val score = mutableStateOf(0.0)
@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.requiredHeight(10.dp))
        Text("Du bist momentan ")
        Spacer(modifier = Modifier.requiredHeight(30.dp))
        Image(
            painter = painterResource(id = R.drawable.tree_1),
            contentDescription = "Small Tree",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.requiredHeight(5.dp))
        val text = score.value.toString()
        Text(text = "$text Social Points",fontSize = 35.sp, color = Blue_medium)
        Text("Einsteiger ", fontWeight = FontWeight.W900,fontSize = 30.sp,)
        Spacer(modifier = Modifier.requiredHeight(30.dp))
        Button(onClick = {
            navController.navigate("explore") }){
            Text(text = "Werde zum GiroHero")
        }
        Spacer(modifier = Modifier.requiredHeight(10.dp))
        Text("und erkunde die aktuellen Hilferufe!")

    }

}