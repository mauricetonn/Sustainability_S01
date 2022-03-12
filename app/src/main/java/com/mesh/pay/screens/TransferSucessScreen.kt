package com.mesh.pay.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mesh.pay.R
import com.mesh.pay.ui.theme.Blue_medium
import com.mesh.pay.ui.theme.Green_medium

@Composable
fun TransferSucessScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier
                .padding(3.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Icon(
                Icons.Outlined.Done,
                contentDescription = "done",
                tint = Green_medium,
                modifier = Modifier.size(30.dp)
            )
            Text(
                color = Color.Gray,
                text = "Überweisung erfolgreich!",
                fontWeight = FontWeight.Normal,
            )
        }
        Row(Modifier.padding(2.dp)) {
            Text(
                text = "Herzlichen Glückwunsch!",
            )
        }
        Text("Du bist ein ")
        Spacer(modifier = Modifier.requiredHeight(30.dp))
        Image(
            painter = painterResource(id = R.drawable.tree_1),
            contentDescription = "Small Tree",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.requiredHeight(5.dp))
        val text = score.value.toString()
        Text(text = "$text Social Points", fontSize = 35.sp, color = Blue_medium)
        Text("Weltverbesserer", fontWeight = FontWeight.W900,fontSize = 30.sp,)
        Spacer(modifier = Modifier.requiredHeight(5.dp))
        Text("Noch 200 Social Points zum", fontWeight = FontWeight.Normal,fontSize = 25.sp,)
        Text("Giro Hero", fontWeight = FontWeight.Bold,fontSize = 30.sp,)

    }
}