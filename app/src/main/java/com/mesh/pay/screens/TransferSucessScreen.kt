package com.mesh.pay.screens

import android.graphics.Paint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
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
        Spacer(modifier = Modifier.requiredHeight(30.dp))

        Row(Modifier.padding(2.dp)) {
            Text(
                text = "Herzlichen Glückwunsch!", fontStyle = FontStyle.Italic
            )
        }
        Text("Du bist ein ")
        Spacer(modifier = Modifier.requiredHeight(30.dp))
        Image(
            painter = painterResource(id = R.drawable.tree_2),
            contentDescription = "Small Tree",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.requiredHeight(5.dp))
        val text = score.value.toString()
        Text(text = "$text Social Points", fontSize = 20.sp, color = Blue_medium)
        Spacer(modifier = Modifier.requiredHeight(10.dp))
        Text("Weltverbesserer", fontWeight = FontWeight.Light, fontSize = 35.sp,)
        Spacer(modifier = Modifier.requiredHeight(21.dp))
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.7F)
                .clip(RoundedCornerShape(10.dp))
                .shadow(3.dp, RoundedCornerShape(10.dp)),
            elevation = 20.dp,
            border = BorderStroke(2.dp, Color.LightGray)
        ) {
            val points_left = 1700 - score.value
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.6F)
                    .padding(10.dp)
                    .background(color = Green_medium),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Noch $points_left Social Points zum",
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp,textAlign = TextAlign.Center,
                    color = Color.White
                )
                Text("Giro Hero", fontWeight = FontWeight.Bold, fontSize = 30.sp,color = Color.White)
                Spacer(modifier = Modifier.requiredHeight(3.dp))
            }
        }
            Column(
                modifier =
                    Modifier.fillMaxWidth(0.4F),
            horizontalAlignment = Alignment.CenterHorizontally
            ){
            Image(
                    painter = painterResource(id = R.drawable.superhero),
                    contentDescription = "Small Tree",
                    modifier = Modifier.size(300.dp)
                )
            }

        }
    }
}
