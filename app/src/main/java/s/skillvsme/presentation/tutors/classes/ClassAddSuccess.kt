package s.skillvsme.presentation.tutors.classes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import s.skillvsme.common.Route
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.SkillvsmeSuccessScreen
import s.skillvsme.presentation.tutors.navigation.BottomNavigation


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
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
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
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}