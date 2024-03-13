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
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun EditLanguageStud(navController: NavController) {
    SetStatusBarColor(color = Color.Transparent)
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ProfileAppBar(
                    backgroundColor = Color.Black, modifier = Modifier, backgroundImage = painterResource(
                        id = R.drawable.rectangle5,
                    ), contentSize = 151.dp, bottomCornerRadius = 30.dp, navController =navController
                )
                Spacer(modifier = Modifier.weight(0.03f))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp, start = 16.dp, end = 16.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                        Spacer(modifier = Modifier.weight(0.25f))
                        Text(
                            text = "Kamal Tyagi",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.weight(0.31f))
                        EditTextLabel(
                            value = "English",
                            text = "App Language",
                            trailinicon = painterResource(id = R.drawable.arrow_down),
                            spacer = 10.dp,
                        )
                        Spacer(modifier = Modifier.weight(2.75f))
                        SkillvsmeButton(label = "Save Changes", modifier = Modifier.fillMaxWidth()) {
                        }
                        Spacer(modifier = Modifier.weight(0.15f))
                        SkillvsmeButton(
                            label = "Back",
                            primary = false,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            onClick = {
                                navController.popBackStack()
                            }
                        )
                        Spacer(modifier = Modifier.weight(0.9f))
                }
            }
        },
        bottomBar = { BottomNavigation(navController = navController) }
    )

}