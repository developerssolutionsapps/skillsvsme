package s.skillvsme.presentation.tutors.classes

import android.annotation.SuppressLint
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import s.skillvsme.common.Fonts
import s.skillvsme.presentation.components.BookedClassesListItem
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.UnBookedClassesListItem
import s.skillvsme.presentation.student.navigation.BottomNavigation
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.lightGrey

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TutorsClassesScreen(
    navController:NavController
){
    var upcomingSelected by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()
    val density = LocalDensity.current
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(
            initialValue = BottomSheetValue.Collapsed,
            density = density
        )
    )
    BackHandler {
        if (bottomSheetScaffoldState.bottomSheetState.isExpanded) {
            scope.launch {
                bottomSheetScaffoldState.bottomSheetState.collapse()
            }
        } else {
            // Navigate back or handle back button press in another way
            navController.popBackStack()
        }
    }
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetPeekHeight = 0.dp,
        sheetContent = {
            CancelClassBottomSheet(navController = navController)
            LaunchedEffect(key1 = Unit) {
                scope.launch {
                    bottomSheetScaffoldState.bottomSheetState.collapse()
                }
            }
        },
        sheetBackgroundColor = Color.Gray.copy(alpha = 0.5f), // Set sheet background color
        modifier = Modifier.background(Color.Gray.copy(alpha = 0.5f))
    ) {
        Scaffold(
            topBar = {
                SimpleAppBar(navController = navController, text = "Checkout")
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(20.dp)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Row {
                            Surface(
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable {
                                        upcomingSelected = true
                                    },
                                shape = RoundedCornerShape(24.dp),
                                color = if (upcomingSelected) black else lightGrey
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(12.dp)
                                        .fillMaxWidth(),
                                    text = "Upcoming",
                                    textAlign = TextAlign.Center,
                                    fontFamily = Fonts.jostFontFamily
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Surface(
                                modifier = Modifier
                                    .weight(1f)
                                    .background(lightGrey)
                                    .clickable {
                                        upcomingSelected = false
                                    },
                                shape = RoundedCornerShape(24.dp),
                                color = if (upcomingSelected) lightGrey else black
                            ) {
                                Text(
                                    modifier = Modifier
                                        .padding(12.dp)
                                        .fillMaxWidth(),
                                    text = "Past",
                                    textAlign = TextAlign.Center,
                                    fontFamily = Fonts.jostFontFamily
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    repeat(6) {
                        if (upcomingSelected) {
                            BookedClassesListItem(
                                day = "Wed",
                                date = "29",
                                month = "Nov",
                                cancelClicked = {
                                    scope.launch {
                                        bottomSheetScaffoldState.bottomSheetState.expand()
                                    }
                                }
                            )
                        } else {
                            UnBookedClassesListItem(
                                day = "Wed",
                                date = "29",
                                month = "Nov",
                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .height(16.dp)
                        )
                    }
                }
            },
            bottomBar = {
                BottomNavigation(navController = navController)
            }
        )
    }
}