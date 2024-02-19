package s.skillvsme.presentation.tutors

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.presentation.components.TutorsListComponent
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.white


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TutorsList(
    navController:NavController
) {
    Scaffold (
        topBar = {
            Surface(
                shadowElevation = 3.dp,
                modifier = Modifier
                    .fillMaxWidth(),
                color = white
            ) {
                TopAppBar(
                    title = {
                        Text(
                            "Tutors",
                            fontFamily = Fonts.headlandOneFontFamily,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 28.dp),
                            textAlign = TextAlign.Center,
                        )
                    },
                    navigationIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.right_arrow),
                            contentDescription = "right arrow",
                            modifier = Modifier
                                .clickable {
                                    navController.popBackStack()
                                }
                        )
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = white),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                )
            }
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
            s.skillvsme.presentation.homeScreen.navigation.BottomNavigation(navController = navController)
        }
    )

}