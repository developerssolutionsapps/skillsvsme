package s.skillvsme.presentation.tutors

import androidx.compose.runtime.Composable
import s.skillvsme.presentation.components.SkillvsmeSuccessScreen


@Composable
fun AppointmentConfirmationSuccess() {
    SkillvsmeSuccessScreen(
    successMessage = "Appointment Confirmed",
    buttonText = "View all classes",
    buttonOnclickAction = {},
    backButtonText = "Back to home",
    backButtonOnclickAction = {},
    )
}