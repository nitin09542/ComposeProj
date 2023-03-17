package com.example.composecomponent

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecomponent.ui.theme.ComposeComponentTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentTheme() {
                // A surface container using the 'background' color from the theme
                setContent {
                    Scaffold(topBar =
                    {
                        TopAppBar {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.Menu, contentDescription = "Menu")
                            }

                            Column(
                                modifier = Modifier.padding(start = 30.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,

                                ) {
                                Text(
                                    text = "Demo App",
                                    color = Color.Red,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.End,
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(Icons.Filled.Search, contentDescription = "Search")

                                }
                            }

                        }
                    }) {
                        MyScreen()
                    }
                }
            }
        }
    }

    @Composable
    private fun setTitle(s: String) {
        Text(s)
    }

    @Composable
    fun MyScreen() {
        val textState = remember { mutableStateOf("") }
        Box ( modifier = Modifier.padding(20.dp),
           ){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    label = { Text("Enter User Name") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))
                TextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    label = { Text("Enter User Name") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))
                
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        startActivity(Intent(this@MainActivity,AnotherActivity::class.java))
                    }) {
                    Text(
                        modifier = Modifier.padding(5.dp),
                        text = "Log In")
                    
                }

            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeComponentTheme {
            //SimpleText("Android")
        }
    }


}