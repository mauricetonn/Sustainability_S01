package com.mesh.pay.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mesh.pay.R
import com.mesh.pay.ui.theme.Green_medium

/**
 *
 */
@Composable
fun HomeScreen(navController: NavController) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Card(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .clip(RectangleShape)
                .shadow(3.dp, RectangleShape),
            elevation = 20.dp,
            border = BorderStroke(2.dp, Color.LightGray)
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    Modifier
                        .background(Color.LightGray)
                        .padding(3.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        color = Color.White,
                        text = "HeroGiro",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    //Spacer(modifier = Modifier.requiredWidth(100.dp))
                    Icon(Icons.Outlined.Refresh, contentDescription = "refresh", tint = Color.White)
                }
                Spacer(modifier = Modifier.requiredHeight(5.dp))
                Row() {
                    Text(
                        color = Color.Gray,
                        text = "DE02200505501015871393",
                        fontWeight = FontWeight.Light,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(modifier = Modifier.requiredWidth(40.dp))
                    Text(
                        color = Green_medium,
                        text = "4.007,89 €",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif
                    )
                }
                Spacer(modifier = Modifier.requiredHeight(5.dp))
                Row(Modifier.padding(2.dp)) {
                    Text(
                        color = Color.Gray,
                        text = "Henry Hero",
                    )
                }
                Spacer(modifier = Modifier.requiredHeight(5.dp))

                Row(
                    Modifier
                        .background(Color.Red)
                        .padding(3.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        color = Color.White,
                        text = "Zum Finanzstatus",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light,

                        )
                }
            }
        }
        Spacer(modifier = Modifier.requiredHeight(5.dp))
        Card(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .clip(RectangleShape)
                .shadow(3.dp, RectangleShape),
            elevation = 20.dp,
            border = BorderStroke(2.dp, Color.LightGray)
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    Modifier

                        .padding(3.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = { navController.navigate("transfer") }, Modifier.requiredWidth(100.dp)) {
                        Column(Modifier.requiredWidth(100.dp)  ,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painterResource(id = R.drawable.cash_multiple),
                                contentDescription = "ueberweisung"
                            )
                            Text(
                                text = "Überweisen",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.ExtraLight,
                            )
                        }
                    }
                    //Spacer(modifier = Modifier.requiredWidth(100.dp))
                    IconButton(onClick = { /*TODO*/ }, Modifier.requiredWidth(100.dp)) {
                        Column(Modifier.requiredWidth(100.dp)  ,
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painterResource(id = R.drawable.contactless_payment_circle_outline),
                                contentDescription = "Apple Pay"
                            )
                            Text(
                                text = "Apple Pay",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.ExtraLight,
                            )
                        }
                    }
                    IconButton(onClick = { /*TODO*/ }, Modifier.requiredWidth(100.dp)) {
                        Column(Modifier.requiredWidth(100.dp)  ,
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painterResource(id = R.drawable.email_outline),
                                contentDescription = "Postfach"
                            )
                            Text(
                                text = "Postfach",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.ExtraLight,
                            )
                        }
                    }
                }

            }

        }
        Spacer(modifier = Modifier.requiredHeight(100.dp))
        Button(onClick = { navController.navigate("explore") }){
            Text(text = "Werde zum GiroHero")
        }
        Spacer(modifier = Modifier.requiredHeight(10.dp))
        Text("und erkunde die aktuellen Hilferufe!")
    }
}

