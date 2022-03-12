package com.mesh.pay.ui.theme.components.topBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview

var menuClicked= mutableStateOf(false)

/**
     * Todo: Implement the navigation menu and the info button
     */
    @Composable
    fun DisplayTopAppBar(title : String) : Unit{
        val topAppBar = TopAppBar(
            title = { Text(title)},
            navigationIcon = {
                IconButton(onClick = {
                    menuClicked.value = !menuClicked.value
                }) {
                    Icon(Icons.Filled.Menu, contentDescription = null)
                }
            },
            actions = {
                // RowScope here, so these icons will be placed horizontally
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Search, contentDescription = "Localized description")
                }

            }
        )
    return topAppBar
    }


@Preview
@Composable
fun PreviewTopBar() {
    DisplayTopAppBar("hOME")
}

