package s.skillvsme.presentation.student.tutors

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.TutorsListComponent
import s.skillvsme.presentation.student.navigation.BottomNavigation
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.white


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TutorsList(
    navController:NavController
) {
    SetStatusBarColor(color = white)
    Scaffold (
        topBar = {
            SimpleAppBar(navController = navController, text = "Tutors", canNavigateBack = false)
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
            ) {
                TutorsListComponent(
                    name = "Alexander Brik",
                    bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
                    rating = 5.0,
                    navController = navController,
                    profile = painterResource(id = R.drawable.profile1)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Divider(
                    thickness = 1.dp,
                    color = black
                )
                Spacer(modifier = Modifier.height(8.dp))
                TutorsListComponent(
                    name = "Alexander Brik",
                    bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
                    rating = 4.8,
                    navController = navController,
                    profile = painterResource(id = R.drawable.profile2),
                    isLive = false
                )
                Spacer(modifier = Modifier.height(16.dp))
                Divider(
                    thickness = 1.dp,
                    color = black
                )
                Spacer(modifier = Modifier.height(8.dp))
                TutorsListComponent(
                    name = "Alexander Brik",
                    bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
                    rating = 2.9,
                    navController = navController,
                    profile = painterResource(id = R.drawable.profile3),
                    isLive = false
                )
                Spacer(modifier = Modifier.height(16.dp))
                Divider(
                    thickness = 1.dp,
                    color = black
                )
                Spacer(modifier = Modifier.height(8.dp))
                TutorsListComponent(
                    name = "Alexander Brik",
                    bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
                    rating = 4.5,
                    navController = navController,
                    profile = painterResource(id = R.drawable.profile1)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Divider(
                    thickness = 1.dp,
                    color = black
                )
                Spacer(modifier = Modifier.height(8.dp))
                TutorsListComponent(
                    name = "Alexander Brik",
                    bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
                    rating = 5.0,
                    navController = navController,
                    profile = painterResource(id = R.drawable.profile3)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Divider(
                    thickness = 1.dp,
                    color = black
                )
                Spacer(modifier = Modifier.height(8.dp))
                TutorsListComponent(
                    name = "Alexander Brik",
                    bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
                    rating = 4.2,
                    navController = navController,
                    profile = painterResource(id = R.drawable.profile2),
                    isLive = false
                )
                Spacer(modifier = Modifier.height(16.dp))
                Divider(
                    thickness = 1.dp,
                    color = black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(modifier = Modifier.height(40.dp))
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )

}