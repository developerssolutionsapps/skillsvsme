package s.skillvsme.presentation.tutors.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.purple
import s.skillvsme.ui.theme.white
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter

@SuppressLint("SuspiciousIndentation")
@Composable
fun WeekView(selectedDay: Int,monthSelected:Month,yearSelected:Int, onDaySelected: (Int,Month,Int) -> Unit) {
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("E")


    for (i in 0 until 30) {
        val day = currentDate.plusDays(i.toLong())
        val month=day.month
        val currentYear=day.year
        val dayOfWeek = day.format(formatter)
        val dayOfMonth = day.dayOfMonth
        val isSelected = dayOfMonth == selectedDay
        val isToday = day == currentDate
            DayItem(
                dayOfWeek = dayOfWeek,
                dayOfMonth = dayOfMonth,
                isSelected = isSelected,
                isToday = isToday,
                onDaySelected = { onDaySelected(dayOfMonth,month,currentYear) } // Pass the selected day to the callback
            )

    }
    Log.e("date",currentDate.toString())
}


@Composable
fun DayItem(
    dayOfWeek: String,
    dayOfMonth: Int,
    isSelected: Boolean,
    isToday: Boolean,
    onDaySelected: () -> Unit
) {
    Column(
        modifier = Modifier
            .size(56.dp)
            .background(if(isSelected) white else Color.Transparent)
            .clickable { onDaySelected() },
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = dayOfWeek,
            style = TextStyle(
                fontFamily = Fonts.jostFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = if (isSelected) Color.Black else if (isToday) Color.Black else Color.Gray
            )
        )
        Text(
            text = dayOfMonth.toString(),
            style = TextStyle(
                fontFamily = Fonts.jostFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = black
            ),
        )
        if (isSelected) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(RoundedCornerShape(50))
                    .background(purple)
            )
        }
    }
}