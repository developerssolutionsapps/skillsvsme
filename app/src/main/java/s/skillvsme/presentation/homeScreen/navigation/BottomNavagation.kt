package s.skillvsme.presentation.homeScreen.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import s.skillvsme.common.Route
import s.skillvsme.presentation.homeScreen.HomePage
import s.skillvsme.presentation.tutors.TutorsList
import s.skillvsme.presentation.userprofilestudent.UserProfile

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = ScreenNavigation.Home.screenroute) {
        composable(Route.Student.Home.Home) {
            HomePage(
                navController=navController
            )
        }
        composable(Route.Student.Tutor.TutorsList) {
            TutorsList(navController=navController)
        }
        composable(Route.Student.Streaming.LiveStream) {
            HomePage(
                navController=navController
            )
        }
        composable(Route.Student.Classes.UpcomingClasses) {
            HomePage(
                navController=navController
            )

        }
        composable(Route.Student.Profile.StudentProfile) {
        UserProfile()
        }
    }
}
@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        ScreenNavigation.Home,
        ScreenNavigation.Tutor,
        ScreenNavigation.Stream,
        ScreenNavigation.Classes,
        ScreenNavigation.Account,
    )
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .shadow(elevation = 10.dp)
    ) {
        BottomNavigation(
            elevation = 10.dp,
            backgroundColor = Color.White

        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title,
                            modifier = Modifier.size(25.dp),
                            tint = Color.Black
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    },
                    selectedContentColor = Color.DarkGray,
                    unselectedContentColor = Color.Black.copy(alpha = 0.4f),
                    alwaysShowLabel = true,
                    selected = currentRoute == item.screenroute,
                    onClick = {
                        navController.navigate(item.screenroute) {

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
