package s.skillvsme.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


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
                SkillvsmeBorderRadioBtn(
                    modifier = Modifier.fillMaxWidth(),
                    selectedValue = selectedTime,
                    label = time
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}