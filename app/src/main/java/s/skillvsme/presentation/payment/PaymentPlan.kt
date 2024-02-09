package s.skillvsme.presentation.payment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import s.skillvsme.presentation.components.SkillvsmeRadioBtn
import s.skillvsme.presentation.components.SkillvsmeRadioPrice
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.ui.theme.purple

@Composable
fun PaymentPlan() {
    val selectedValue = "30 mins/week"
    val selecctedPayPlan = "Every 3 months"
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        // Step One
        SkillvsmeText(
            label = "Step 1",
            value = "Choose your learning hours",
            labelColor = purple,
            boldValue = true,
            isValueHeading = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        SkillvsmeRadioBtn(
            modifier = Modifier.fillMaxWidth(),
            selectedValue = selectedValue,
            label = "30 mins/week"
        )
        Spacer(modifier = Modifier.height(8.dp))
        SkillvsmeRadioBtn(
            modifier = Modifier.fillMaxWidth(),
            selectedValue = selectedValue,
            label = "1 hr/week"
        )
        Spacer(modifier = Modifier.height(8.dp))
        SkillvsmeRadioBtn(
            modifier = Modifier.fillMaxWidth(),
            selectedValue = selectedValue,
            label = "1.5 hr/week"
        )
        Spacer(modifier = Modifier.height(8.dp))
        SkillvsmeRadioBtn(
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
            isValueHeading = true
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
    }
}