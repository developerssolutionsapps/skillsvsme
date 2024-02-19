package s.skillvsme.presentation.tutors

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import s.skillvsme.presentation.components.SkillvsmeSuccessScreen
import s.skillvsme.presentation.homeScreen.navigation.BottomNavigation


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppointmentConfirmationSuccess(
    navController: NavController
) {
    Scaffold(
        content = {
            SkillvsmeSuccessScreen(
                successMessage = "Appointment Confirmed",
                buttonText = "View all classes",
                buttonOnclickAction = {},
                backButtonText = "Back to home",
                backButtonOnclickAction = {},
            )
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}