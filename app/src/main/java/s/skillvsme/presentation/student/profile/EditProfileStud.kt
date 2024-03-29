package s.skillvsme.presentation.student.profile

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.EditTextLabel
import s.skillvsme.presentation.components.ProfileAppBar
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.student.navigation.BottomNavigation
import s.skillvsme.ui.theme.black

@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun EditProfileStud(
    navController: NavController
) {
    SetStatusBarColor(color = Color.Transparent)
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ProfileAppBar(
                    backgroundColor = Color.Black,
                    modifier = Modifier,
                    backgroundImage = painterResource(
                        id = R.drawable.rectangle5,
                    ),
                    contentSize = 151.dp,
                    bottomCornerRadius = 30.dp,
                    navController = navController
                )
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 40.dp, start = 16.dp, end = 16.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Spacer(modifier = Modifier.height(25.dp))
                            Text(
                                text = "Kamal Tyagi",
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            EditTextLabel(value = "Kamal Tyagi", text = "User name")
                            Spacer(modifier = Modifier.height(15.dp))
                            EditTextLabel(value = "+999 45821365479", text = "Phone number")
                            Spacer(modifier = Modifier.height(15.dp))
                            EditTextLabel(value = "Califonia, USA", text = "Location")
                        }
                        Column {
                            SkillvsmeButton(
                                label = "Save changes",
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            SkillvsmeButton(
                                label = "Back",
                                primary = false,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                onClick = {
                                    navController.popBackStack()
                                }
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}

