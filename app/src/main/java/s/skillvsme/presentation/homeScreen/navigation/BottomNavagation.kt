package s.skillvsme.presentation.homeScreen.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material.Card
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import s.skillvsme.common.Route
import s.skillvsme.common.Route.Student.Onboarding.Onboarding1
import s.skillvsme.presentation.classes.Classes
import s.skillvsme.presentation.homeScreen.HomePage
import s.skillvsme.presentation.onboarding.CodeVerification
import s.skillvsme.presentation.onboarding.JoinAs
import s.skillvsme.presentation.onboarding.Onboarding1
import s.skillvsme.presentation.onboarding.Onboarding2
import s.skillvsme.presentation.onboarding.Onboarding3
import s.skillvsme.presentation.onboarding.Signup
import s.skillvsme.presentation.streaming.Streaming
import s.skillvsme.presentation.tutors.TutorsList
import s.skillvsme.presentation.userprofilestudent.EditProfile
import s.skillvsme.presentation.userprofilestudent.StudentProfile
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.green
import s.skillvsme.ui.theme.white
import s.skillvsme.utils.coloredShadow

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController,
        startDestination = Route.Student.Profile.EditProfile) {
        composable(Route.Student.Home.Home) {
            HomePage(
                navController = navController
            )
        }
        composable(Route.Student.Tutor.TutorsList) {
            TutorsList(navController = navController)
        }
        composable(Route.Student.Streaming.LiveStream) {
            Streaming(navController)
        }
        composable(Route.Student.Classes.UpcomingClasses) {
            Classes(navController = navController)
        }
        composable(Route.Student.Profile.StudentProfile) {
            StudentProfile(navController = navController)
        }

        composable(Route.Student.Onboarding.Onboarding1) {
            Onboarding1(navController = navController)
        }
        composable(Route.Student.Onboarding.Onboarding2) {
            Onboarding2(navController = navController)
        }
        composable(Route.Student.Onboarding.Onboarding3) {
            Onboarding3(navController = navController)
        }
        composable(Route.Student.Profile.EditProfile) {
            EditProfile(navController)
        }
        composable(Route.Student.Onboarding.JoinAS) {
            JoinAs(navController = navController)
        }
        composable(Route.Student.Onboarding.SignUp) {
            Signup(navController = navController)
        }
        composable(Route.Student.Onboarding.CodeVerification) {
            CodeVerification(navController = navController)
        }

    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        ScreenNavigation.Home,
        ScreenNavigation.Tutor,
        ScreenNavigation.Stream,
        ScreenNavigation.Classes,
        ScreenNavigation.Account,
    )
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(green)
            .height(70.dp)
            .fillMaxWidth()
        ,
        shape = RectangleShape,
        elevation = (-5).dp
    ) {
        BottomNavigation(
            backgroundColor = white, modifier = Modifier
                .coloredShadow(
                    color = darkGrey,
                    borderRadius = 1.dp,
                    blurRadius = 1.dp,
                    offsetY = (-4).dp,
                    offsetX = 0.dp,
                    spread = 1f
                )
                .padding(top = 1.dp)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Box {
                            Icon(
                                painterResource(id = item.icon),
                                contentDescription = item.title,
                                modifier = Modifier.size(25.dp),
                                tint = black
                            )

                        }
                    },
                    label = {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                text = item.title,
                                fontSize = 12.sp,
                                color = black
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            if (currentRoute == item.screenroute) {
                                Box(
                                    modifier = Modifier
                                        .size(8.dp)
                                        .clip(RoundedCornerShape(50))
                                        .background(Color.Red)
                                )
                            }
                        }

                    },
                    selectedContentColor = black,
                    unselectedContentColor = black,
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

