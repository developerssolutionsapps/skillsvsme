package s.skillvsme.presentation.tutors.classes

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.common.Route
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.SkillvsmeSuccessScreen
import s.skillvsme.presentation.tutors.navigation.BottomNavigation


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClassAddSuccess(
    navController: NavController
) {
    Scaffold(
        topBar = {
            SimpleAppBar(navController = navController, text = "Add Class")
        },
        content = {
            Spacer(modifier = Modifier.height(80.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                SkillvsmeSuccessScreen(
                    successMessage = "Class added successfully",
                    buttonText = "Add another class",
                    backButtonText = "Back to home",
                    buttonOnclickAction = {
                        navController.navigate(Route.Tutor.Classes.AddClass)
                    },
                    backButtonOnclickAction = {
                        navController.popBackStack()
                    }
                )
                Spacer(modifier = Modifier.height(100.dp))
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}