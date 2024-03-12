package s.skillvsme.presentation.student.payment

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.common.Route
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeBorderRadioBtn
import s.skillvsme.presentation.components.SkillvsmeRadioPrice
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.student.navigation.BottomNavigation
import s.skillvsme.ui.theme.purple
import s.skillvsme.ui.theme.white

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun PaymentPlan(
    navController: NavController
) {
    SetStatusBarColor(color = white)
    Scaffold(
        topBar = {
            SimpleAppBar(navController = navController, text = "Customize your plan")
        },
        content = {
            val selectedValue = "30 mins/week"
            val selecctedPayPlan = "Every 3 months"
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                // Step One
                SkillvsmeText(
                    label = "Step 1",
                    value = "Choose your learning hours",
                    labelColor = purple,
                    labelSize = 18,
                    valueSize = 24,
                    boldValue = true,
                    boldLabel = false
                )
                Spacer(modifier = Modifier.height(8.dp))
                SkillvsmeBorderRadioBtn(
                    modifier = Modifier.fillMaxWidth(),
                    selectedValue = selectedValue,
                    label = "30 mins/week"
                )
                Spacer(modifier = Modifier.height(8.dp))
                SkillvsmeBorderRadioBtn(
                    modifier = Modifier.fillMaxWidth(),
                    selectedValue = selectedValue,
                    label = "1 hr/week"
                )
                Spacer(modifier = Modifier.height(8.dp))
                SkillvsmeBorderRadioBtn(
                    modifier = Modifier.fillMaxWidth(),
                    selectedValue = selectedValue,
                    label = "1.5 hr/week"
                )
                Spacer(modifier = Modifier.height(8.dp))
                SkillvsmeBorderRadioBtn(
                    modifier = Modifier.fillMaxWidth(),
                    selectedValue = selectedValue,
                    label = "2.5 hr/week"
                )
                Spacer(modifier = Modifier.height(8.dp))

                Spacer(modifier = Modifier.height(16.dp))
                // Step Two
                SkillvsmeText(
                    label = "Step 2",
                    value = "Select payment plan",
                    labelColor = purple,
                    boldValue = true,
                    labelSize = 18,
                    valueSize = 24,
                    boldLabel = false
                )
                Spacer(modifier = Modifier.height(8.dp))
                SkillvsmeRadioPrice(
                    modifier = Modifier.fillMaxWidth(),
                    selectedValue = selecctedPayPlan,
                    label = "Monthly",
                    price = 30.0
                )
                Spacer(modifier = Modifier.height(8.dp))
                SkillvsmeRadioPrice(
                    modifier = Modifier.fillMaxWidth(),
                    selectedValue = selecctedPayPlan,
                    label = "Every 3 months",
                    discount = 10.0,
                    price = 27.0
                )
                Spacer(modifier = Modifier.height(8.dp))
                SkillvsmeRadioPrice(
                    modifier = Modifier.fillMaxWidth(),
                    selectedValue = selecctedPayPlan,
                    label = "Every 6 months",
                    discount = 15.0,
                    price = 25.0
                )
                Spacer(modifier = Modifier.height(8.dp))
                SkillvsmeRadioPrice(
                    modifier = Modifier.fillMaxWidth(),
                    selectedValue = selecctedPayPlan,
                    label = "Annually",
                    discount = 20.0,
                    price = 22.0
                )
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(modifier = Modifier.height(40.dp))
                SkillvsmeButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Proceed to Checkout",
                    primary = true,
                    onClick = {
                        navController.navigate(Route.Student.Payment.CheckOut)
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
                Spacer(modifier = Modifier.height(80.dp))
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}