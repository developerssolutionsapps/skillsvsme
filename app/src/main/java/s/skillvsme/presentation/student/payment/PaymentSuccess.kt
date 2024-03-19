package s.skillvsme.presentation.student.payment

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.common.Route
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.SkillvsmeSuccessScreen
import s.skillvsme.presentation.student.navigation.BottomNavigation
import s.skillvsme.ui.theme.white


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun PaymentSuccess(
    navController: NavController
) {
    SetStatusBarColor(color = white)
    Scaffold(
        topBar = {
            SimpleAppBar(navController = navController, text = "Payment")
        },
        content = {
            Spacer(modifier = Modifier.height(40.dp))
            SkillvsmeSuccessScreen(
                successMessage = "Payment successful",
                successInfo = "Keep the momentum going\nand schedule your first class",
                buttonText = "Schedule a class",
                buttonOnclickAction = {
                    navController.navigate(Route.Student.Tutor.Schedule)
                },
                backButtonText = "Back to home",
                backButtonOnclickAction = {
                    navController.navigate(Route.Student.Home.Home)
                },
            )
            Spacer(modifier = Modifier.height(40.dp))
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}