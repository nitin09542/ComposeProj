package com.example.composecomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class AnotherActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* setContent {
             var myItems = arrayListOf<String>()
             for (i in 0..100) {
                 myItems.add("dczsfj")
             }
             ComposeComponentTheme {
                 Scaffold(
                     topBar =
                     {
                         TopAppBar {
                             Text(text = "Home Page")
                         }


                     },
                     bottomBar = {
                         BottomNavigation {

                         }
                     }) {
                     Box(Modifier.padding(20.dp)) {
                         MyList(items = myItems)
                     }


                 }
             }
         }*/
        setContent {
            MainScreenView()

        }
    }


    @Composable
    fun MyAppNavHost(
        modifier: Modifier = Modifier,
        navController: NavHostController = rememberNavController(),
        startDestination: String = "profile"
    ) {
        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = startDestination
        ) {
            composable("profile") {
                ProfileScreen(
                    onNavigateToFriends = { navController.navigate("friendsList") },
                    /*...*/
                )
            }
            // composable("friendslist") { FriendsListScreen(/*...*/) }
        }
    }

    @Composable
    fun ProfileScreen(
        onNavigateToFriends: () -> Unit,
        /*...*/
    ) {
        /*...*/
        Button(onClick = onNavigateToFriends) {
            Text(text = "See friends list")
        }
    }

    @Composable
    fun MyList(items: List<String>) {
        LazyColumn {
            items(items) { item ->

                Column(Modifier.padding(10.dp)) {
                    Card(
                        modifier = Modifier.fillMaxSize(),
                        elevation = 2.dp
                    ) {
                        Text(
                            text = item,
                            Modifier.padding(10.dp)
                        )
                    }
                }

            }
        }
    }



    @Composable
    fun NetworkScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.teal_700))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "My Network Screen",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
    }

    @Composable
    fun AddPostScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.teal_700))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Add Post Screen",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
    }


    @Composable
    fun NotificationScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.teal_700))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Notification Screen",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
    }


    @Composable
    fun JobScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.teal_700))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Jobs Screen",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
    }

    @Composable
    fun MainScreenView() {
        val navController = rememberNavController()
        Scaffold(
            topBar =
            {
                TopAppBar {
                    Text(text = "Home Page")
                }


            },
            bottomBar = { BottomNavigation(navController = navController) }
        ) {

            NavigationGraph(navController = navController)
        }
    }

    @Composable
    fun HomeScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.teal_700))
                .wrapContentSize(Alignment.Center)
        ) {
            Column() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // First view
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(64.dp)
                            .background(Color.Blue)
                    )

                    // Second view
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(64.dp)
                            .background(Color.Green)
                    )
                }

                Modifier.padding(bottom = 20.dp)
                MyList(items = arrayListOf("jhhj","juu","kllllklk","lkkllk","kpopoii"))

            }
        }
    }
    @Composable
    fun NavigationGraph(navController: NavHostController) {
        NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
            composable(BottomNavItem.Home.screen_route) {
               HomeScreen()
            }
            composable(BottomNavItem.MyNetwork.screen_route) {
                NetworkScreen()
            }
            composable(BottomNavItem.AddPost.screen_route) {
                AddPostScreen()
            }
            composable(BottomNavItem.Notification.screen_route) {
                NotificationScreen()
            }
            composable(BottomNavItem.Jobs.screen_route) {
                JobScreen()
            }
        }
    }

    @Composable
    fun BottomNavigation(navController: NavController) {
        val items = listOf(
            BottomNavItem.Home,
            BottomNavItem.MyNetwork,
            BottomNavItem.AddPost,
            BottomNavItem.Notification,
            BottomNavItem.Jobs
        )
        BottomNavigation(
            backgroundColor = colorResource(id = R.color.teal_200),
            contentColor = Color.Black
        ) {

            var navBackStackEntry = navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry.value?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontSize = 9.sp
                        )
                    },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Black.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = currentRoute == item.screen_route,
                    onClick = {
                        navController.navigate(item.screen_route) {

                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }

}

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Home : BottomNavItem("Home", R.drawable.ic_baseline_home_24, "home")
    object MyNetwork : BottomNavItem("My Network", R.drawable.ic_baseline_post_add_24, "my_network")
    object AddPost : BottomNavItem("Post", R.drawable.ic_baseline_notifications_none_24, "add_post")
    object Notification : BottomNavItem("Notification", R.drawable.ic_baseline_post_add_24, "notification")
    object Jobs : BottomNavItem("Jobs",R.drawable.ic_baseline_post_add_24, "jobs")
}