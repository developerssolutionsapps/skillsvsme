package s.skillvsme.presentation.classes

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun classes(
    navController:NavController
){
    Scaffold (
        content = {
            Text(text = "Classes")
        },
        bottomBar = {
            s.skillvsme.presentation.homeScreen.navigation.BottomNavigation(navController = navController)
        }
    )


}