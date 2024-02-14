package s.skillvsme

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
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

import s.skillvsme.presentation.homeScreen.navigation.NavigationGraph
import s.skillvsme.presentation.onboarding.Onboarding1
import s.skillvsme.presentation.tutors.TutorsList
import s.skillvsme.presentation.userprofilestudent.EditLanguage
import s.skillvsme.presentation.userprofilestudent.EditProfile
import s.skillvsme.presentation.userprofilestudent.NotificationScreen
import s.skillvsme.presentation.userprofilestudent.PaymentSettings
import s.skillvsme.presentation.userprofilestudent.UserProfile
import s.skillvsme.presentation.userprofilestudent.paymentMethod
import s.skillvsme.ui.theme.SkillVsMeTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
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
                        NavigationGraph(navController = navController)
                    }
                }
            }
        }
    }
}


