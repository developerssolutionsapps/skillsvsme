package s.skillvsme.presentation.tutors

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.presentation.components.TutorsListComponent
import s.skillvsme.ui.theme.black


@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TutorsList(
    navController:NavController
) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text("Tutors!")
                },
                navigationIcon = {
                    Image(painter = painterResource(id = R.drawable.right_arrow), contentDescription = "right arrow")
                },
                backgroundColor = Color.White
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
            ) {
                Spacer(modifier = Modifier.height(48.dp))
                TutorsListComponent(
                    name = "Alexander Brik",
                    bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
                    rating = 5.0,
                    profile = painterResource(id = R.drawable.profile1)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider(
                    thickness = 1.dp,
                    color = black
                )
                Spacer(modifier = Modifier.height(8.dp))
                TutorsListComponent(
                    name = "Alexander Brik",
                    bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
                    rating = 4.8,
                    profile = painterResource(id = R.drawable.profile2),
                    isLive = false
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider(
                    thickness = 1.dp,
                    color = black
                )
                Spacer(modifier = Modifier.height(8.dp))
                TutorsListComponent(
                    name = "Alexander Brik",
                    bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
                    rating = 2.9,
                    profile = painterResource(id = R.drawable.profile3),
                    isLive = false
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider(
                    thickness = 1.dp,
                    color = black
                )
                Spacer(modifier = Modifier.height(8.dp))
                TutorsListComponent(
                    name = "Alexander Brik",
                    bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
                    rating = 4.5,
                    profile = painterResource(id = R.drawable.profile1)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider(
                    thickness = 1.dp,
                    color = black
                )
                Spacer(modifier = Modifier.height(8.dp))
                TutorsListComponent(
                    name = "Alexander Brik",
                    bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
                    rating = 5.0,
                    profile = painterResource(id = R.drawable.profile3)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider(
                    thickness = 1.dp,
                    color = black
                )
                Spacer(modifier = Modifier.height(8.dp))
                TutorsListComponent(
                    name = "Alexander Brik",
                    bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
                    rating = 4.2,
                    profile = painterResource(id = R.drawable.profile2),
                    isLive = false
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider(
                    thickness = 1.dp,
                    color = black
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        },
        bottomBar = {
            s.skillvsme.presentation.homeScreen.navigation.BottomNavigation(navController = navController)
        }
    )

}