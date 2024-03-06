package s.skillvsme.presentation.student.classes

import android.annotation.SuppressLint
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.PastClassesItem
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeRadioBtn
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.components.UpComingClassesItem
import s.skillvsme.presentation.onboarding.noRippleClickable
import s.skillvsme.presentation.student.navigation.BottomNavigation
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.lightGrey
import s.skillvsme.ui.theme.red
import s.skillvsme.ui.theme.white

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Classes(
    navController:NavController
){
    SetStatusBarColor(color = white)
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
            navController.popBackStack()
        }
    }
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetPeekHeight = 0.dp,
        sheetContent = {
            CancelBottomSheet(
                navController = navController,
                cancelClicked = {
                    scope.launch (Dispatchers.IO) {
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                }
            )
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
                        shape = RoundedCornerShape(20.dp),
                        color= lightGrey
                    ) {
                        Row {
                            Surface(
                                modifier = Modifier
                                    .weight(1f)
                                    .noRippleClickable {
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
                                    fontFamily = Fonts.jostFontFamily,
                                    color = if (upcomingSelected) white else black
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Surface(
                                modifier = Modifier
                                    .weight(1f)
                                    .background(lightGrey)
                                    .noRippleClickable {
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
                                    fontFamily = Fonts.jostFontFamily,
                                    color = if (upcomingSelected) black else lightGrey
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    repeat(6) {
                        if (upcomingSelected) {
                            UpComingClassesItem(
                                day = "Wed",
                                date = "29",
                                month = "Nov",
                                name = "Alexander Brik",
                                location = "California, USA | 6:30 PM",
                                image = "",
                                rating = 5.0,
                                time = "10:00 - 11:00 AM",
                                cancelClicked = {
                                    scope.launch {
                                        bottomSheetScaffoldState.bottomSheetState.expand()
                                    }
                                },
                                navController = navController
                            )
                        } else {
                            PastClassesItem(
                                day = "Wed",
                                date = "29",
                                month = "Nov",
                                name = "Alexander Brik",
                                location = "California, USA | 6:30 PM",
                                image = "",
                                rating = 5.0,
                                time = "10:00 - 11:00 AM",
                                watchClicked = {
                                    navController.navigate(Route.Student.Classes.VideoScreen)
                                }
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

@Composable
fun CancelBottomSheet(
    navController: NavController,
    cancelClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkGrey.copy(alpha = 0.2f)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Image(
                        modifier = Modifier
                            .clickable {
                                cancelClicked()
                            },
                        painter = painterResource(id = R.drawable.cancel),
                        contentDescription = null
                    )
                }
                Row {
                    Image(
                        modifier = Modifier
                            .clickable {
                                navController.popBackStack()
                            },
                        painter = painterResource(id = R.drawable.warning_1),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    SkillvsmeText(
                        valueColor = red,
                        valueSize = 14,
                        value = "Please note that your maximum limit is 2 classes/month. If you cancel this class you will remain with only 1 cancelation left"
                    )
                }
                SkillvsmeRadioBtn(
                    modifier = Modifier,
                    selectedValue = "I booked by mistake",
                    label = "I booked by mistake"
                )
                SkillvsmeRadioBtn(
                    modifier = Modifier,
                    selectedValue = "I booked by mistake",
                    label = "I have change of plan"
                )
                SkillvsmeRadioBtn(
                    modifier = Modifier,
                    selectedValue = "I booked by mistake",
                    label = "I have change of plan"
                )
                SkillvsmeRadioBtn(
                    modifier = Modifier,
                    selectedValue = "I booked by mistake",
                    label = "I have change of plan"
                )
                SkillvsmeRadioBtn(
                    modifier = Modifier,
                    selectedValue = "I booked by mistake",
                    label = "I have change of plan"
                )
                SkillvsmeRadioBtn(
                    modifier = Modifier,
                    selectedValue = "I booked by mistake",
                    label = "I have change of plan"
                )
                SkillvsmeButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = "Cancel class",
                    onClick = {}
                )
            }
        }
    }
}