package com.example.testapp.presentation.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.testapp.presentation.navigation.NavRoutes
import com.example.testapp.presentation.ui.screens.userList.UserListRoute
import com.example.testapp.presentation.ui.screens.userDetails.UserDetailsRoute
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                val nav = rememberNavController()
                NavHost(
                    navController = nav,
                    startDestination = NavRoutes.USER_LIST
                ) {
                    composable(NavRoutes.USER_LIST) {
                        UserListRoute(
                            onUserClick = { id ->
                                // Navigate to details using userId as argument
                                nav.navigate("${NavRoutes.USER_DETAILS}/$id")
                            }
                        )
                    }
                    composable(
                        route = NavRoutes.USER_DETAILS_ROUTE,
                        arguments = listOf(
                            navArgument(NavRoutes.ARG_USER_ID) { type = NavType.StringType }
                        )
                    ) {
                        UserDetailsRoute(onBack = { nav.popBackStack() })
                    }
                }
            }
        }
    }
}