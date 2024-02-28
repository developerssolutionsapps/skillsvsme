package s.skillvsme.presentation.tutors.TutorsProfile

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.common.Route
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.SkillvsmeBorderRadioBtn
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.tutors.navigation.BottomNavigation
import s.skillvsme.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WithdrawFunds(
    navController: NavController
) {
    SetStatusBarColor(color = white)
    val selectedValue = "Paypal"
    Scaffold(
        topBar = {
            SimpleAppBar(navController = navController, text = "Withdraw Funds")
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Spacer(modifier = Modifier.height(80.dp))
                    SkillvsmeText(
                        value = "Choose withdrawal method",
                        valueSize = 18,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    SkillvsmeBorderRadioBtn(
                        modifier = Modifier.fillMaxWidth(),
                        selectedValue = selectedValue,
                        label = selectedValue
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    SkillvsmeBorderRadioBtn(
                        modifier = Modifier.fillMaxWidth(),
                        selectedValue = selectedValue,
                        label = "Skrill"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    SkillvsmeBorderRadioBtn(
                        modifier = Modifier.fillMaxWidth(),
                        selectedValue = selectedValue,
                        label = "Stripe"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    SkillvsmeBorderRadioBtn(
                        modifier = Modifier.fillMaxWidth(),
                        selectedValue = selectedValue,
                        label = "Local bank"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Spacer(modifier = Modifier.height(16.dp))
                }
                Column {
                    SkillvsmeButton(
                        modifier = Modifier.fillMaxWidth(),
                        label = "Proceed",
                        primary = true,
                        onClick = {
                            navController.navigate(Route.Tutor.Profile.TransactionSuccess)
                        }
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    SkillvsmeButton(
                        modifier = Modifier.fillMaxWidth(),
                        label = "back",
                        primary = false,
                        onClick = {
                            navController.popBackStack()
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Spacer(modifier = Modifier.height(40.dp))
                }
                Spacer(modifier = Modifier.height(130.dp))
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}