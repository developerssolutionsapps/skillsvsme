package s.skillvsme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import s.skillvsme.common.Route
import s.skillvsme.presentation.homeScreen.HomePage
import s.skillvsme.presentation.homeScreen.HomeScreen
import s.skillvsme.presentation.userprofilestudent.EditProfile
import s.skillvsme.presentation.userprofilestudent.UserProfile
import s.skillvsme.ui.theme.SkillVsMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
//            window.statusBarColor = C
            androidx.compose.material.Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                SkillVsMeTheme {
                    androidx.compose.material.Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = Route.Home.Home
                        ) {
                            composable(Route.Home.Home) {
                                EditProfile()
                            }
                            }
                        }
                    }
                }
            }
        }
    }


