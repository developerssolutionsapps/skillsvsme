package s.skillvsme.presentation.student.notification

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.Notification
import s.skillvsme.presentation.student.navigation.BottomNavigation
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.white


@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(
    navController: NavController
) {
    SetStatusBarColor(color = white)
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() },modifier = Modifier.size(30.dp)) {
                        Icon(Icons.Default.KeyboardArrowLeft, contentDescription = null, )
                    }
                },
                title = {
                    Text("Notification", fontSize = 24.sp, fontWeight = FontWeight.Normal)
                },
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp,top=50.dp)
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                Spacer(modifier = Modifier.height(80.dp))
                repeat(16){
                    Notification(iconStart = painterResource(id = R.drawable.notification_1))
                    Divider(
                        color = darkGrey,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth() // Adjust width as needed
                    )
                }
                Spacer(modifier = Modifier.height(80.dp))
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )

}