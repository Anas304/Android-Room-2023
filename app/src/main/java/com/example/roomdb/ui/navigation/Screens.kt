package com.example.roomdb.ui.navigation
import com.example.roomdb.R


sealed class Screens( val titleRes: Int, val route : String) {
    object Home : Screens(titleRes = R.string.app_name, route = "home_screen")
}