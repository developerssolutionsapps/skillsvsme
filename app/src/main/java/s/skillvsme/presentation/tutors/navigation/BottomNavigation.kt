package s.skillvsme.presentation.tutors.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import s.skillvsme.R
import s.skillvsme.ui.theme.black
import s.skillvsme.utils.coloredShadow

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        ScreenNavigation.Home,
        ScreenNavigation.Stream,
        ScreenNavigation.Classess,
        ScreenNavigation.Accounts,
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // Bottom Navigation
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(Color.Green)
                .height(70.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            shape = RectangleShape,
            elevation = (-5).dp
        ) {
            BottomNavigation(
                backgroundColor = Color.White,
                modifier = Modifier
                    .coloredShadow(
                        color = Color.Gray.copy(alpha = 0.2f),
                        borderRadius = 4.dp,
                        blurRadius = 4.dp,
                        offsetY = (-4).dp,
                        offsetX = 0.dp,
                        spread = 4f
                    )
                    .padding(top = 1.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEachIndexed { index, item ->
                 // Exclude Tutor item
                        BottomNavigationItem(
                            icon = {
                                Box {
                                    Icon(
                                        painterResource(id = item.icon),
                                        contentDescription = item.title,
                                        modifier = Modifier.size(25.dp),
                                        tint = Color.Black
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
                                        color = Color.Black
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
                            selectedContentColor = Color.Black,
                            unselectedContentColor = Color.Black,
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

                    if (index == 1 ) {
                        Spacer(modifier = Modifier.padding(start =40.dp))
                    }
                    if (index == 1 ) {
                        Spacer(modifier = Modifier.padding(end =40.dp))
                    }

                }
            }
        }


        // Floating Button
        FloatingActionButton(
            onClick = { /* Handle floating button click */ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 35.dp)
                .size(70.dp),
                backgroundColor = black,
            shape = CircleShape

        ) {
            Icon(
                painter = painterResource(id = R.drawable.addition),
                contentDescription = "Add",
                tint = Color.White
            )
        }
    }
}
