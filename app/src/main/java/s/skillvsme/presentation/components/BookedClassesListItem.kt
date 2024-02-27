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
fun BookedClassesListItem(
    day: String,
    date: String,
    month: String,
    cancelClicked: () -> Unit = {}
) {
    Row {
        DateCard(day = day, date = date, month = month)
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            repeat(2){
                Spacer(modifier = Modifier.height(10.dp))
                UpcomingClasses(
                    join = "Cancel",
                    buttonOnclick = cancelClicked
                )
            }
        }
    }
}