package com.example.composecomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composecomponent.ui.theme.ComposeComponentTheme

class NavActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyNavHost(navController)
        }
    }


    @Composable
    fun MyFragment() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello from MyFragment!")
        }
    }

    @Composable
    fun MyNavHost(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = "myFragment"
        ) {
            composable("myFragment") { MyFragment() }
        }
    }


    @Composable
    fun Greeting2(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview2() {
        ComposeComponentTheme {
            Greeting2("Android")
        }
    }
}