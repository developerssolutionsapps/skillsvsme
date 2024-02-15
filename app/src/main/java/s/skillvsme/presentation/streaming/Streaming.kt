package s.skillvsme.presentation.streaming

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import s.skillvsme.presentation.homeScreen.navigation.BottomNavigation

@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Streaming(
    navController:NavController
){
    Scaffold (
        content = {
            Text(text = "Streaming")
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}