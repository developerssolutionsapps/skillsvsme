package s.skillvsme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import s.skillvsme.common.Route
import s.skillvsme.presentation.homeScreen.HomePage
import s.skillvsme.presentation.onboarding.CodeVerification
import s.skillvsme.presentation.onboarding.JoinAs
import s.skillvsme.presentation.onboarding.Onboarding1
import s.skillvsme.presentation.onboarding.Onboarding2
import s.skillvsme.presentation.onboarding.Onboarding3
import s.skillvsme.presentation.onboarding.Signup
import s.skillvsme.ui.theme.SkillVsMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
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
                            startDestination = Route.Student.Home.Home
                        ) {
                            composable(Route.Student.Onboarding.Onboarding1) {
                                Onboarding1(navController = navController)
                            }
                            composable(Route.Student.Onboarding.Onboarding2) {
                                Onboarding2(navController = navController)
                            }
                            composable(Route.Student.Onboarding.Onboarding3) {
                                Onboarding3(navController = navController)
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
                            composable(Route.Student.Home.Home) {
                               HomePage(navController = navController)
                            }
                            }
                        }
                    }
                }
            }
        }
    }


