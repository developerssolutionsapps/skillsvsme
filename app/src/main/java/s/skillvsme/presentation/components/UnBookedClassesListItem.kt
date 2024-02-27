package s.skillvsme.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UnBookedClassesListItem(
    day: String,
    date: String,
    month: String,
    cancelClicked: () -> Unit = {}
) {
    Row {
        DateCard(day = day, date = date, month = month)
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Spacer(modifier = Modifier.height(10.dp))
            EditUnbookedClasses(label = "10:00 - 11:00 AM")
            Spacer(modifier = Modifier.height(10.dp))
            EditUnbookedClasses(label = "12:00 - 1:00 PM")
            Spacer(modifier = Modifier.height(10.dp))
            EditUnbookedClasses(label = "3:00 - 4:00 PM")
            Spacer(modifier = Modifier.height(10.dp))
            AddClass()
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}