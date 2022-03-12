package com.mesh.pay

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mesh.pay.navigation.BottomNavItem
import com.mesh.pay.navigation.BottomNavigationBar
import com.mesh.pay.navigation.screen
import com.mesh.pay.screens.ExploreScreen
import com.mesh.pay.screens.HomeScreen
import com.mesh.pay.screens.ProfileScreen
import com.mesh.pay.ui.theme.Blue_dark
import com.mesh.pay.ui.theme.HelpingHandTheme
import com.mesh.pay.ui.theme.components.topBar.DisplayTopAppBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (allPermissionsGranted()) {
            //showing camera preview if user grants permissions
            setViewContent()
        } else {
            ActivityCompat.requestPermissions(
                    this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
            )
        }
}

    override fun onResume() {
        super.onResume()
        window.decorView.postDelayed({
            window.decorView.systemUiVisibility = FLAGS_FULLSCREEN
        }, IMMERSIVE_FLAG_TIMEOUT)
    }
    override fun onRequestPermissionsResult(
            requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                //showing camera preview if user grants permissions
                setViewContent()
            } else {
                Toast.makeText(
                        this,
                        "Permissions not granted by the user.",
                        Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }


    /**
    Function to set the Theme and the first page showing a record button and camera preview
    Orientation is set to Landscape
     */
    fun setViewContent() {
        setContent {
            HelpingHandTheme(darkTheme = false) {
                //Screen Orientation
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

                Scaffold(
                    drawerContent = {
                        Row(
                            Modifier
                                .requiredHeight(56.dp)
                                .background(Blue_dark)
                                .fillMaxWidth()
                                ,
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.Start
                        ){
                        Image(
                            painter = painterResource(id = R.drawable.logo_lb_bw_quer),
                            contentDescription = "Small Tree",
                            modifier = Modifier
                                .size(150.dp)
                                .padding(2.dp)

                        )}
                        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                            Icon(Icons.Outlined.Home, "home")
                            Spacer(modifier = Modifier.requiredWidth(15.dp))
                            Text("Startseite")
                        }
                        Divider()
                        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                            Icon(painterResource(id = R.drawable.contactless_payment_circle_outline), "home")
                            Spacer(modifier = Modifier.requiredWidth(15.dp))
                            Text("Apple Pay")
                        }
                        Divider()
                        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                            Icon(painterResource(id = R.drawable.email_outline), "home")
                            Spacer(modifier = Modifier.requiredWidth(15.dp))
                            Text("Postfach")
                        }
                        Divider()
                        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                            Icon(painterResource(id = R.drawable.notebook_edit_outline), "home")
                            Spacer(modifier = Modifier.requiredWidth(15.dp))
                            Text("Merkzettel")
                        }
                        Divider()
                        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                            Icon(painterResource(id = R.drawable.currency_eur), "home")
                            Spacer(modifier = Modifier.requiredWidth(15.dp))
                            Text("Finanzstatus")
                        }
                        Divider()
                        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                            Icon(painterResource(id = R.drawable.cash_multiple), "home")
                            Spacer(modifier = Modifier.requiredWidth(15.dp))
                            Text("Banking")
                        }
                        Divider()
                        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                            Icon(painterResource(id = R.drawable.bullseye_arrow), "home")
                            Spacer(modifier = Modifier.requiredWidth(15.dp))
                            Text("Service-Center")
                        }
                        DropdownMenuItem(onClick = { /* Handle refresh! */ } , Modifier.background(
                            Color.LightGray)) {
                            Spacer(modifier = Modifier.requiredWidth(35.dp))
                            Text("weitere Funkionen")
                            Spacer(modifier = Modifier.requiredWidth(30.dp))
                            Icon(Icons.Outlined.ArrowDropDown, "home")
                        }
                        Divider(Modifier.requiredHeight(3.dp))
                        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                            Icon(Icons.Outlined.Settings, "home")
                            Spacer(modifier = Modifier.requiredWidth(15.dp))
                            Text("Einstellungen")
                        }
                        Divider()
                        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                            Icon(painterResource(id = R.drawable.power), "home")
                            Spacer(modifier = Modifier.requiredWidth(15.dp))
                            Text("Abmelden")
                        }

                                    },
                    scaffoldState = scaffoldState,
                    bottomBar = {
                            BottomNavigationBar(
                                    items = listOf(
                                            BottomNavItem(
                                                    "Banking",
                                                    "home",
                                                    id = R.drawable.cash_multiple
                                            ),
                                            BottomNavItem(
                                                    "Give and Take",
                                                    "explore",
                                                    id = R.drawable.hand_heart
                                            ),
                                            BottomNavItem(
                                                    "Your Profie",
                                                    route = "profile",
                                                    id = R.drawable.tree
                                            )
                                    ),
                                    navController = navController,
                                    onItemClick = {
                                        navController.navigate(it.route)
                                    }
                            )
                        },

                        topBar = { DisplayTopAppBar(title = screen.value) },


                        ) {

                    val padding = Modifier.padding(
                            it.calculateLeftPadding(layoutDirection = androidx.compose.ui.unit.LayoutDirection.Ltr),
                            it.calculateRightPadding(layoutDirection = androidx.compose.ui.unit.LayoutDirection.Ltr),
                            it.calculateTopPadding(),
                            it.calculateBottomPadding()
                    )
                    Surface(
                            modifier = padding
                    ) {
                        Navigation(navController = navController)
                    }
                }

            }
        }
    }

    /**
     *
     */
    @Composable
    fun Navigation(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "home") {

            composable("home") {
                HomeScreen(navController = navController)
            }
            composable("explore", arguments = listOf(navArgument("uri") {
                type = NavType.StringType
                nullable = true //if there was no video created yet and the user clicks on NewMemory
                defaultValue = null
            })) { backStackEntry ->
               ExploreScreen(navController)
            }
            composable("profile") {
                ProfileScreen(navController)
            }
        }
    }


    /**
    Function to check if all permissions are granted by user
     */
    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
                baseContext, it
        ) == PackageManager.PERMISSION_GRANTED
    }
    companion object {


        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS = arrayOf(
            Manifest.permission.INTERNET
        )
        private const val IMMERSIVE_FLAG_TIMEOUT = 500L
        const val FLAGS_FULLSCREEN =
            View.SYSTEM_UI_FLAG_LOW_PROFILE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelpingHandTheme {
    }
}