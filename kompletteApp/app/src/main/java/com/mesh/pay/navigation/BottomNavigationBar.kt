package com.mesh.pay.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


/**
 * Global Variable screen that contains the name of the screen selected
 */
var screen : MutableState<String> =  mutableStateOf("Home")

    /**
     * Function that handles the BottomNavigationBar, called from the
     * Scaffold Bottombar
     */
    @Composable
    fun BottomNavigationBar(items: List<BottomNavItem>,
                            navController: NavController,
                            modifier: Modifier = Modifier,
                            onItemClick: (BottomNavItem) -> Unit) {
    //Current navigation back stack entry as a MutableState.
    // When the given navController changes the back stack due to a
    // NavController.navigate or NavController.popBackStack this will trigger a
    // recompose and return the top entry on the back stack.
        val backStackEntry = navController.currentBackStackEntryAsState()


        BottomNavigation (){
            items.forEach{  item ->
                ///route of the item:
                val selected = item.route == backStackEntry.value?.destination?.route
                if(selected) { screen.value = item.name}
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    icon = {
                        Column(horizontalAlignment = CenterHorizontally) {

                                Icon(
                                    painter = painterResource(id = item.id),
                                    contentDescription = item.name
                                )
                            }


                    }
                )
            }
        }
}

@Preview
@Composable
fun PreviewBottomBar() {


}
