package s.skillvsme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import s.skillvsme.presentation.onboarding.CodeVerification
import s.skillvsme.presentation.onboarding.JoinAs
import s.skillvsme.presentation.onboarding.Onboarding1
import s.skillvsme.presentation.onboarding.Onboarding2
import s.skillvsme.presentation.onboarding.Onboarding3
import s.skillvsme.presentation.onboarding.Signup
import s.skillvsme.presentation.payment.PaymentPlan

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaymentPlan()
        }
    }
}
