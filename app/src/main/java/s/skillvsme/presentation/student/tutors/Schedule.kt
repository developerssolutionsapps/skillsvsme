package s.skillvsme.presentation.student.tutors

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
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeScheduleTimeline
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.student.navigation.BottomNavigation
import s.skillvsme.ui.theme.purple


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Schedule(
    navController: NavController
) {
    Scaffold(
        topBar = {
           SimpleAppBar(navController = navController, text = "Schedule")
        },
        content = {
            val timeline1 = "10:00 - 11:00 AM"
            val timeline2 = "11:00 - 11:30 AM"
            val timeline3 = "6:00 - 8:50 PM"
            val selectedTime = timeline3
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                SkillvsmeText(value = "Available Slots", valueColor = purple)
                SkillvsmeScheduleTimeline(
                    day = "Wed",
                    date = "29",
                    month = "Nov",
                    timelineList = listOf(timeline1, timeline2, timeline3),
                    selectedTime = selectedTime
                )
                SkillvsmeScheduleTimeline(
                    day = "Thu",
                    date = "30",
                    month = "Nov",
                    timelineList = listOf(timeline1, timeline2, timeline3),
                    selectedTime = "selectedTime"
                )
                SkillvsmeScheduleTimeline(
                    day = "Fri",
                    date = "1",
                    month = "Dec",
                    timelineList = listOf(timeline1, timeline2, timeline3),
                    selectedTime = "selectedTime"
                )
                SkillvsmeScheduleTimeline(
                    day = "Mon",
                    date = "4",
                    month = "Dec",
                    timelineList = listOf(timeline1, timeline2, timeline3),
                    selectedTime = "selectedTime"
                )
                SkillvsmeScheduleTimeline(
                    day = "Tue",
                    date = "5",
                    month = "Dec",
                    timelineList = listOf(timeline1, timeline2, timeline3),
                    selectedTime = "selectedTime"
                )
                Spacer(modifier = Modifier.height(24.dp))
                SkillvsmeButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Confirm Appointment",
                    primary = true,
                    onClick = {
                        navController.navigate(Route.Student.Tutor.AppointmentConfirmation)
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
                Spacer(modifier = Modifier.height(60.dp))
            }
        },
        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}