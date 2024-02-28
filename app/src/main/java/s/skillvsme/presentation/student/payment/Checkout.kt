package s.skillvsme.presentation.student.payment

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.components.SkillvsmeTextField
import s.skillvsme.presentation.student.navigation.BottomNavigation
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.purple
import s.skillvsme.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Checkout(
    navController: NavController
) {
    SetStatusBarColor(color = white)
    Scaffold(
        topBar = {
            SimpleAppBar(navController = navController, text = "Checkout")
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Spacer(modifier = Modifier.height(16.dp))
                    SkillvsmeText(
                        value = "Promocode",
                        boldValue = true,
                        valueColor = purple,
                        valueSize = 18
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        SkillvsmeTextField(
                            modifier = Modifier.fillMaxWidth(0.5f),
                            value = "ChRIS24",
                            onChange = {},
                            hintSize = 18,
                            label = "",
                            hint = "",
                            fieldDescription = ""
                        )
                        SkillvsmeButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 28.dp, start = 24.dp),
                            label = "Apply",
                            primary = true,
                            onClick = {}
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        SkillvsmeText(
                            value = "30 min per day (12 months)",
                            valueSize = 18
                        )
                        SkillvsmeText(
                            value = "360 USD",
                            boldValue = true,
                            valueSize = 18
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        SkillvsmeText(
                            value = "yearly subscription discount",
                            valueSize = 18
                        )
                        SkillvsmeText(
                            value = "-60 USD",
                            boldValue = true,
                            valueSize = 18
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        SkillvsmeText(
                            value = "Promotion discount",
                            valueSize = 18
                        )
                        SkillvsmeText(
                            value = "-30 USD",
                            boldValue = true,
                            valueSize = 18
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row {
                        Divider(
                            thickness = 1.dp,
                            color = black
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            fontFamily = Fonts.jostFontFamily,
                            text = "Total",
                            color = black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            fontFamily = Fonts.jostFontFamily,
                            text = "270.00 USD",
                            color = black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
                Column {
                    SkillvsmeButton(
                        modifier = Modifier.fillMaxWidth(),
                        label = "Proceed to payment",
                        primary = true,
                        onClick = {
                            navController.navigate(Route.Student.Payment.Payment)
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    SkillvsmeButton(
                        modifier = Modifier.fillMaxWidth(),
                        label = "Back",
                        primary = false,
                        onClick = {
                            navController.popBackStack()
                        }
                    )
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}