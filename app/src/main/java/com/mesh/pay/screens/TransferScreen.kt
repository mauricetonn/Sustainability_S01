package com.mesh.pay.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mesh.pay.ui.theme.Green_medium

val socialCheckState = mutableStateOf(false)
val co2CheckState =  mutableStateOf(false)

@Composable
fun TransferScreen(navController: NavController) {
   Column(
       Modifier.padding(20.dp)
           .fillMaxWidth()) {
       Text(text = "AUFTRAGGEBERKONTO",  fontWeight = FontWeight.Light)
       Card(
           modifier = Modifier
               .padding(5.dp)
               .fillMaxWidth()
               .clip(RectangleShape)
               .shadow(3.dp, RectangleShape),
           elevation = 20.dp,
           border = BorderStroke(2.dp, Color.LightGray)
       ) {
           Column(
               modifier = Modifier
                   .fillMaxWidth(),
               horizontalAlignment = Alignment.Start
           ) {
               Row(
                   Modifier
                       .padding(3.dp)
                       .fillMaxWidth(),
                   horizontalArrangement = Arrangement.Center
               ) {

                   Icon(Icons.Outlined.Refresh, contentDescription = "refresh", tint = Color.Gray, modifier = Modifier.size(10.dp))
                   Text(
                       color = Color.Gray,
                       text = "vor 2 Stunden",
                       fontSize = 10.sp,
                       fontWeight = FontWeight.ExtraLight,
                   )
               }
               Row(Modifier.padding(2.dp)) {
                   Text(
                       color = Color.Gray,
                       text = "HeroGiro",
                   )
               }
               Row() {
                   Text(
                       color = Color.Gray,
                       text = "DE02200505501015871393",
                       fontSize = 12.sp,
                       fontWeight = FontWeight.ExtraLight,
                       fontFamily = FontFamily.SansSerif
                   )
                   Spacer(modifier = Modifier.requiredWidth(35.dp))
                   Text(
                       color = Green_medium,
                       text = "4.007,89",
                       fontSize = 15.sp,
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
           }
       }
       Spacer(modifier = Modifier.requiredHeight(5.dp))
       Text(text = "BEGÜNSTIGTER",  fontWeight = FontWeight.Light)
       Spacer(modifier = Modifier.requiredHeight(5.dp))
       Box(modifier = Modifier.wrapContentSize())
       {
           var name by remember { mutableStateOf(TextFieldValue("Tina")) }
           TextField(
               value = name,
               onValueChange = {
                   name = it
               },
               placeholder = { Text(text = "Name") },
               singleLine = true,

           )
       }
       Spacer(modifier = Modifier.requiredHeight(5.dp))
       Box(modifier = Modifier.wrapContentSize())
       {
           var nachname by remember { mutableStateOf(TextFieldValue("Höflich")) }
           TextField(
               value = nachname,
               onValueChange = {
                   nachname = it
               },
               placeholder = { Text(text = "Nachname") },
               singleLine = true,

           )
       }
       Spacer(modifier = Modifier.requiredHeight(5.dp))
       Box(modifier = Modifier.wrapContentSize())
       {
       var iban by remember { mutableStateOf(TextFieldValue("DE02500105170137075030")) }
       TextField(
           value = iban,
           onValueChange = {
               iban = it
           },
           placeholder = { Text(text = "IBAN") },
           singleLine = true,

       )
   }
       Spacer(modifier = Modifier.requiredHeight(5.dp))
       Box(modifier = Modifier.wrapContentSize())
       {
           var betrag  by remember { mutableStateOf(TextFieldValue("")) }
           TextField(
               value = betrag,
               onValueChange = {
                   betrag = it
               },
               placeholder = { Text(text = "Betrag") },
               singleLine = true,
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

           )
       }
       Spacer(modifier = Modifier.requiredHeight(5.dp))
       Box(modifier = Modifier.wrapContentSize())
       {
           var verwendungszweck by remember { mutableStateOf(TextFieldValue("")) }
           TextField(
               value = verwendungszweck,
               onValueChange = {
                   verwendungszweck = it
               },
               placeholder = { Text(text = "Verwendungszweck") },
               singleLine = true,
           )
       }
       Spacer(modifier = Modifier.requiredHeight(5.dp))
       Row(
           Modifier.fillMaxWidth()
       ) {
           Checkbox(
               checked = co2CheckState.value,
               onCheckedChange = { co2CheckState.value = it }
           )
           Spacer(modifier = Modifier.requiredWidth(5.dp))

           Text ("Ja, ich kompensiere den CO2 Außstoß der Bankserver mit 0.30€", fontWeight = FontWeight.Light)
       }
       Spacer(modifier = Modifier.requiredHeight(5.dp))
       Row(
           Modifier.fillMaxWidth()
       ) {
           Checkbox(
               checked = socialCheckState.value,
               onCheckedChange = { socialCheckState.value = it }
           )
           Spacer(modifier = Modifier.requiredWidth(5.dp))

           Text ("Ja, ich spende 2€ für ein Zugticket von Kiew nach Berlin", fontWeight = FontWeight.Light)
       }
       Button(onClick = {
           if (socialCheckState.value ) {
               score.value +=10
           }
           if(co2CheckState.value)
               score.value +=10

           navController.navigate("sucess") }){
           Text(text = " Senden ")
       }
   }
}