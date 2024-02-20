package s.skillvsme.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.purple


@Composable
fun SkillvsmeScheduleTimeline(
    day: String,
    date: String,
    month: String,
    timelineList: List<String>,
    selectedTime: String,
) {
    Row {
        DateCard(day = day, date = date, month = month)
        Column {
            for (time in timelineList){
                Spacer(modifier = Modifier.height(8.dp))
                SkillvsmeRadioBtn(
                    modifier = Modifier.fillMaxWidth(),
                    selectedValue = selectedTime,
                    label = time
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}