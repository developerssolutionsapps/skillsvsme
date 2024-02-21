package s.skillvsme.presentation.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.ktor.http.ContentType
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.black
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.math.abs

@Composable
fun streaming() {
    val startDate = LocalDate.now()
    val endDate = startDate.withDayOfYear(31).withMonth(12)
    val Year=endDate.format(DateTimeFormatter.ofPattern("yyyy")).toInt()


    // End of the year
    var day by remember {
        mutableStateOf(1)
    }
    var month by remember {
        mutableStateOf(1)
    }
    var year by remember {
        mutableStateOf(2023)
    }
    var lastDayInMonth by remember {
        mutableStateOf(30)
    }
    fun adjustDay() {
        val newLastDayInMonth = lastDayInMonth(month, year)
        if (lastDayInMonth != newLastDayInMonth) {
            lastDayInMonth = newLastDayInMonth
            if (day > newLastDayInMonth) {
                day = lastDayInMonth
            }
        }
    }
    Box(contentAlignment = Alignment.Center){
        Surface(border = BorderStroke(1.dp, black), modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)){

        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            InfiniteCircularList(
                width = 200.dp,
                itemHeight = 70.dp,
                items = listOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"), //(1..30).map { it.toString() },
                initialItem = "December",
                textStyle = TextStyle(fontSize = 18.sp, fontFamily = Fonts.jostFontFamily),
                textColor = Color.LightGray,
                selectedTextColor = Color.Black,
                onItemSelected = { i, item ->
                    month = i + 1
                    adjustDay()
                }
            )
            Spacer(modifier = Modifier.width(20.dp))
            InfiniteCircularList(
                width = 50.dp,
                itemHeight = 70.dp,
                items = (1..lastDayInMonth).toMutableList(),
                initialItem = day,
                textStyle = TextStyle(fontSize = 18.sp, fontFamily = Fonts.jostFontFamily),
                textColor = Color.LightGray,
                selectedTextColor = Color.Black,
                onItemSelected = { i, item ->
                    day = item
                }
            )
        }
    }


}

private fun lastDayInMonth(month: Int, year: Int): Int {
    return if (month != 2) {
        31 - (month - 1) % 7 % 2
    } else {
        if (year and 3 == 0 && (year % 25 != 0 || year and 15 == 0)) {
            29
        } else {
            28
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T> InfiniteCircularList(
    width: Dp,
    itemHeight: Dp,
    numberOfDisplayedItems: Int = 3,
    items: List<T>,
    initialItem: T,
    itemScaleFact: Float = 1.5f,
    textStyle: TextStyle,
    textColor: Color,
    selectedTextColor: Color,
    onItemSelected: (index: Int, item: T) -> Unit = { _, _ -> }
) {
    val itemHalfHeight = LocalDensity.current.run { itemHeight.toPx() / 2f }
    val scrollState = rememberLazyListState(0)
    var lastSelectedIndex by remember {
        mutableStateOf(0)
    }
    var itemsState by remember {
        mutableStateOf(items)
    }
    LaunchedEffect(items) {
        var targetIndex = items.indexOf(initialItem) - 1
        targetIndex += ((Int.MAX_VALUE / 2) / items.size) * items.size
        itemsState = items
        lastSelectedIndex = targetIndex
        scrollState.scrollToItem(targetIndex)
    }
    LazyColumn(
        modifier = Modifier
            .width(width)
            .height(itemHeight * numberOfDisplayedItems),
        state = scrollState,
        flingBehavior = rememberSnapFlingBehavior(
            lazyListState = scrollState
        )
    ) {
        items(
            count = Int.MAX_VALUE,
            itemContent = { i ->
                val item = itemsState[i % itemsState.size]
                Box(
                    modifier = Modifier
                        .height(itemHeight)
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            val y = coordinates.positionInParent().y - itemHalfHeight
                            val parentHalfHeight =
                                (coordinates.parentCoordinates?.size?.height ?: 0) / 2f
                            val isSelected =
                                (y > parentHalfHeight - itemHalfHeight && y < parentHalfHeight + itemHalfHeight)
                            if (isSelected && lastSelectedIndex != i) {
                                onItemSelected(i % itemsState.size, item)
                                lastSelectedIndex = i
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {

                    Surface(modifier = Modifier.fillMaxWidth().padding(20.dp),
                        border = BorderStroke(2.dp, black),
                        shape = RectangleShape
                    ) {
                    }
                    Text(
                        text = item.toString(),
                        style = textStyle,
                        color = if (lastSelectedIndex == i) {
                            selectedTextColor
                        } else {
                            textColor
                        },
                        fontSize = if (lastSelectedIndex == i) {
                            textStyle.fontSize
                        } else {
                            textStyle.fontSize
                        }
                    )
                }
            }
        )
    }
}

