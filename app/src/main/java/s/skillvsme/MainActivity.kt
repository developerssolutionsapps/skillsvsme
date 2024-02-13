package s.skillvsme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import s.skillvsme.common.Route
import s.skillvsme.presentation.homeScreen.HomePage
import s.skillvsme.presentation.homeScreen.HomeScreen
import s.skillvsme.presentation.onboarding.Onboarding1
import s.skillvsme.presentation.userprofilestudent.EditLanguage
import s.skillvsme.presentation.userprofilestudent.EditProfile
import s.skillvsme.presentation.userprofilestudent.NotificationScreen
import s.skillvsme.presentation.userprofilestudent.PaymentSettings
import s.skillvsme.presentation.userprofilestudent.UserProfile
import s.skillvsme.presentation.userprofilestudent.paymentMethod
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
                val systemUiController = rememberSystemUiController()

                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = Color(0xFF7A60F3),
                    )
                }
                SkillVsMeTheme {
                    androidx.compose.material.Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = Route.Student.Onboarding.Onboarding1
                        ) {
                            composable(Route.Student.Onboarding.Onboarding1) {
                                Onboarding1()
                            }
                            }
                        }
                    }
                }
            }
        }
    }


