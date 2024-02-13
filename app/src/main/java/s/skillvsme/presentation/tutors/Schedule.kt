package s.skillvsme.presentation.tutors

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ktor.util.date.WeekDay
import s.skillvsme.presentation.components.SkillvsmeRadioBtn
import s.skillvsme.presentation.components.SkillvsmeScheduleTimeline
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.purple


@Composable
fun Schedule() {
    val timeline1 = "10:00 - 11:00 AM"
    val timeline2 = "11:00 - 11:30 AM"
    val timeline3 = "6:00 - 8:50 PM"
    val selectedTime = timeline3
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
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
    }
}