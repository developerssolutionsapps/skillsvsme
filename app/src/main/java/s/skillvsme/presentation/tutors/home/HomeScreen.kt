package s.skillvsme.presentation.tutors.home


import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.presentation.components.UpcomingClasses
import s.skillvsme.presentation.tutors.classes.CancelClassBottomSheet
import s.skillvsme.presentation.tutors.components.WeekView
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.purple
import s.skillvsme.ui.theme.white
import java.time.Month

@OptIn(ExperimentalMaterialApi::class)
@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TutorHomePage(
    navController: NavController
) {
    var selectedDay by remember { mutableStateOf(0) }
    var selectedMonth by remember { mutableStateOf(Month.JANUARY) }
    var selectedYear by remember { mutableStateOf(0) }
    val scrollState = rememberScrollState()

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
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxSize()
                        .background(white)
                        .verticalScroll(scrollState)
                ) {
                    Column(modifier = Modifier.padding(paddingValues)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Hi Robert!",
                                fontFamily = Fonts.headlandOneFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 30.sp
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            IconButton(onClick = { }) {
                                Image(
                                    painter = painterResource(id = R.drawable.notification),
                                    contentDescription = null, modifier = Modifier.clickable {
                                        navController.navigate(Route.Tutor.Profile.Notifications)
                                    }
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .size(30.dp)
                                    .background(Color.Gray, CircleShape)
                            ) {
                                Image(
                                    painter = (painterResource(id = R.drawable.ellipse1)),
                                    contentDescription = "",
                                    Modifier
                                        .fillMaxSize()
                                        .clickable {
                                            navController.navigate(Route.Tutor.Profile.TutorProfile) {
                                                navController.graph.startDestinationRoute?.let { screen_route ->
                                                    popUpTo(screen_route) {
                                                        saveState = true
                                                    }
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        },
                                    contentScale = ContentScale.Crop,
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(22.dp))
                        Card(
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(26.dp),
                            backgroundColor = Color.Black
                        ) {
                            Box {
                                Image(
                                    painter = painterResource(id = R.drawable.background_lines),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(204.dp),
                                    contentScale = ContentScale.Crop
                                )
                                Column(
                                    modifier = Modifier.padding(top = 16.dp, start = 24.dp)
                                ) {
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        contentAlignment = Alignment.TopStart
                                    ) {
                                        Text(
                                            text = "Go on live stream and\nearn extra gift from\nstudents",
                                            fontFamily = Fonts.jostFontFamily,
                                            fontWeight = FontWeight.SemiBold,
                                            color = white,
                                            fontSize = 26.sp,
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Button(
                                        onClick = {
                                            navController.navigate(Route.Tutor.Streaming.LiveStreamPreview)
                                        },
                                        shape = RoundedCornerShape(21.dp),
                                        modifier = Modifier
                                            .width(128.dp)
                                            .height(45.dp),
                                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                                    ) {
                                        Text(
                                            text = "Go live", fontFamily = Fonts.jostFontFamily,
                                            fontWeight = FontWeight.Normal,
                                            color = black,
                                            fontSize = 20.sp,
                                        )
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Your Classes",
                                fontFamily = Fonts.jostFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                color = black,
                                fontSize = 24.sp,
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "Add",
                                fontFamily = Fonts.jostFontFamily,
                                fontWeight = FontWeight.Normal,
                                color = purple,
                                fontSize = 18.sp,
                            )
                        }
                        Row(
                            Modifier
                                .wrapContentWidth()
                                .horizontalScroll(rememberScrollState())
                        ) {
                            WeekView(
                                selectedDay = selectedDay,
                                monthSelected = selectedMonth,
                                yearSelected = selectedYear
                            ) { day, month, year ->
                                selectedDay = day
                                selectedMonth = month
                                selectedYear = year
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            Modifier.wrapContentWidth(),
                        ) {
                            Box(
                                modifier = Modifier.size(10.dp, 745.dp),
                                contentAlignment = Alignment.TopCenter,
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(2.dp, 730.dp)
                                        .background(color = Color.Gray)
                                )
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    repeat(4) { it ->
                                        if (it == 0) {
                                            Box(
                                                modifier = Modifier
                                                    .size(10.dp)
                                                    .clip(CircleShape)
                                                    .background(Color.White),
                                                contentAlignment = Alignment.Center
                                                // Aligning the circle to the top center
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .size(6.dp)
                                                        .clip(CircleShape)
                                                        .background(black),

                                                    )
                                            }
                                        } else {
                                            Box(
                                                modifier = Modifier
                                                    .size(6.dp)
                                                    .clip(CircleShape)
                                                    .background(Color.Gray),
                                                contentAlignment = Alignment.Center
                                                // Aligning the circle to the top center
                                            ) {
                                                Box(
                                                    modifier = Modifier
                                                        .size(6.dp)
                                                        .clip(CircleShape)

                                                )
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(175.dp))
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(14.dp))
                            Column {
                                UpcomingClasses(
                                    join = "Join",
                                    buttonOnclick = {
                                        navController.navigate(Route.Student.Classes.ClassRoom)
                                    }
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                UpcomingClasses(
                                    join = "Cancel",
                                    buttonOnclick = {
                                        scope.launch {
                                            bottomSheetScaffoldState.bottomSheetState.expand()
                                        }
                                    }
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                UpcomingClasses(
                                    join = "Cancel",
                                    buttonOnclick = {
                                        scope.launch {
                                            bottomSheetScaffoldState.bottomSheetState.expand()
                                        }
                                    }
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                UpcomingClasses(
                                    join = "Cancel",
                                    buttonOnclick = {
                                        scope.launch {
                                            bottomSheetScaffoldState.bottomSheetState.expand()
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            },
            bottomBar = {
                s.skillvsme.presentation.tutors.navigation.BottomNavigation(navController = navController)
            }
        )
    }
}