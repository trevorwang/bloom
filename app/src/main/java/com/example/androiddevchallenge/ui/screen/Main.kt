package com.example.androiddevchallenge.ui.screen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Profile : Screen("profile", "Profile", Icons.Default.AccountCircle)
    object Favorites : Screen("favorites", "Favorites", Icons.Default.FavoriteBorder)
    object Cart : Screen("cart", "Cart", Icons.Default.ShoppingCart)
}

val items = listOf(
    Screen.Home,
    Screen.Favorites,
    Screen.Profile,
    Screen.Cart
)


@Composable
fun Main() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(imageVector = screen.icon, screen.label)
                        },
                        label = { Text(screen.label) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo = navController.graph.startDestination
                                launchSingleTop = true
                            }
                        }, selectedContentColor = MaterialTheme.colors.onPrimary
                    )
                }
            }

        }
    ) {
        NavHost(navController, startDestination = Screen.Home.route) {
            composable(Screen.Home.route) { Home(navController) }
            composable(Screen.Favorites.route) { Favorites(navController) }
            composable(Screen.Profile.route) { Profile(navController) }
            composable(Screen.Cart.route) { Cart(navController) }
        }
    }

}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MainPreviewLight() {
    MyTheme {
        Main()
    }
}


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MainPreviewDark() {
    MyTheme(darkTheme = true) {
        Main()
    }
}
