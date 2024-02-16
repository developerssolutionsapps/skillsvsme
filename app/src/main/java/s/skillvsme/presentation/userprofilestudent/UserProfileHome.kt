package s.skillvsme.presentation.userprofilestudent

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.presentation.components.ProfileAppBar
import s.skillvsme.presentation.components.SkillvsmeText

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserProfile(navController:NavController) {
    Scaffold (
        content = {Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ProfileAppBar(
                backgroundColor = Color.Black, modifier = Modifier, backgroundImage = painterResource(
                    id = R.drawable.rectangle4,
                ), contentSize = 130.dp, bottomCornerRadius = 30.dp
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp, start = 16.dp, end = 16.dp),
            ) {
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Kamal Tyagi",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(15.dp))
                SkillvsmeText(
                    modifier = Modifier.fillMaxWidth(),
                    value = "Edit Profile",
                    iconBeforeSize = 30.dp,
                    iconAfterSize = 8.dp,
                    color = Color.Red,
                    iconBeforeSpacer = 50.dp,
                    iconAfter = painterResource(id = R.drawable.arrow_forward),
                    iconBefore = painterResource(
                        id = R.drawable.edit,
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth() // Adjust width as needed
                    )
                }
                SkillvsmeText(
                    modifier = Modifier.fillMaxWidth(),
                    value = "Language",
                    iconBeforeSize = 30.dp,
                    iconAfterSize = 8.dp,
                    color = Color.Red,
                    iconBeforeSpacer = 50.dp,
                    iconAfter = painterResource(id = R.drawable.arrow_forward),
                    iconBefore = painterResource(
                        id = R.drawable.language__1_,
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth() // Adjust width as needed
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
                SkillvsmeText(
                    modifier = Modifier.fillMaxWidth(),
                    value = "Subscription plan",
                    iconBeforeSize = 30.dp,
                    iconAfterSize = 8.dp,
                    color = Color.Red,
                    iconBeforeSpacer = 50.dp,
                    iconAfter = painterResource(id = R.drawable.arrow_forward),
                    iconBefore = painterResource(
                        id = R.drawable.balance,
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth() // Adjust width as needed
                    )
                }
                SkillvsmeText(
                    modifier = Modifier.fillMaxWidth(),
                    value = "Payment setting",
                    iconBeforeSize = 30.dp,
                    iconAfterSize = 8.dp,
                    color = Color.Red,
                    iconBeforeSpacer = 50.dp,
                    iconAfter = painterResource(id = R.drawable.arrow_forward),
                    iconBefore = painterResource(
                        id = R.drawable.payment,
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth() // Adjust width as needed
                    )
                }
            }
        }}  ,
        bottomBar = {s.skillvsme.presentation.homeScreen.navigation.BottomNavigation(navController = navController)}
    )
}