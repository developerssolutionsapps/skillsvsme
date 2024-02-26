package s.skillvsme.presentation.student.payment

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.common.Route
import s.skillvsme.presentation.components.BorderedSurface
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.components.SkillvsmeTextField
import s.skillvsme.presentation.student.navigation.BottomNavigation
import s.skillvsme.ui.theme.white


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Payment(
    navController: NavController
) {
    Scaffold(
        topBar = {
            SimpleAppBar(navController = navController, text = "Confirmation")
        },
        content = {it ->
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(24.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Spacer(modifier = Modifier.height(16.dp))
                    SkillvsmeText(
                        value = "Please enter your card details",
                        valueSize = 18,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    BorderedSurface(
                        borderWidth = 1.dp,
                        background = white,
                    ) {
                        SkillvsmeTextField(
                            hintSize = 18,
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            value = "1234-5678-9123-4567",
                            onChange = {},
                            label = "Card number",
                            hint = "",
                            fieldDescription = ""
                        )
                        SkillvsmeTextField(
                            hintSize = 18,
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            value = "Jane Doe",
                            onChange = {},
                            label = "Card holder name",
                            hint = "",
                            fieldDescription = ""
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                        ) {
                            SkillvsmeTextField(
                                hintSize = 18,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth(0.5f),
                                value = "03/28",
                                onChange = {},
                                label = "Expiry Date",
                                hint = "MM/YY",
                                fieldDescription = ""
                            )
                            SkillvsmeTextField(
                                hintSize = 18,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth(),
                                value = "111",
                                onChange = {},
                                label = "CFV",
                                hint = "",
                                fieldDescription = ""
                            )
                        }
                    }
                }
                Column {
                    SkillvsmeButton(
                        modifier = Modifier.fillMaxWidth(),
                        label = "Proceed to payment",
                        primary = true,
                        onClick = {
                            navController.navigate(Route.Student.Payment.PaymentSuccess)
                        }
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    SkillvsmeButton(
                        modifier = Modifier.fillMaxWidth(),
                        label = "Back",
                        primary = false,
                        onClick = {
                            navController.popBackStack()
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}