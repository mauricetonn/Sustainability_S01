package com.mesh.pay.ui.theme.components.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import com.mesh.pay.ui.theme.components.topBar.menuClicked

@Composable
fun DisplayMenu()
{
   Surface(
       Modifier.fillMaxWidth(0.7F)
   ) {
       Box(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.TopStart)) {

           DropdownMenu(
               offset = DpOffset.Zero,
               modifier = Modifier.fillMaxWidth(0.6F)
                   .fillMaxHeight(),
               expanded = menuClicked.value,
               onDismissRequest = { menuClicked.value = false }
           ) {
               DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                   Text("Refresh")
               }
               DropdownMenuItem(onClick = { /* Handle settings! */ }) {
                   Text("Settings")
               }
               Divider()
               DropdownMenuItem(onClick = { /* Handle send feedback! */ }) {
                   Text("Send Feedback")
               }
           }
       }
    }
}