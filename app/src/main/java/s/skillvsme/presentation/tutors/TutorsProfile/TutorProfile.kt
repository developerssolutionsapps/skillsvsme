package s.skillvsme.presentation.tutors.TutorsProfile

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
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import s.skillvsme.presentation.components.BottomSheet
import s.skillvsme.presentation.components.ProfileAppBar
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.tutors.homePage.navigation.BottomNavigation
import s.skillvsme.ui.theme.darkGrey

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TutorProfile(navController: NavController) {
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
            BottomSheet(
                iconAvatar = R.drawable.camera,
                iconCamera = R.drawable.delete,
                iconDelete = R.drawable.camera,
                iconGallery = R.drawable.delete,
            )
            LaunchedEffect(key1 = Unit) {
                scope.launch {
                    bottomSheetScaffoldState.bottomSheetState.collapse()
                }
            }
        }, sheetBackgroundColor = Color.Gray.copy(alpha = 0.5f), // Set sheet background color
        modifier = Modifier.background(Color.Gray.copy(alpha = 0.5f))
    ) {
        Scaffold(
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ProfileAppBar(
                        backgroundColor = Color.Black,
                        modifier = Modifier,
                        backgroundImage = painterResource(
                            id = R.drawable.rectangle6,

                            ),
                        cameraIconAvailable = true,
                        scope = scope,
                        bottomSheetScaffoldState = bottomSheetScaffoldState,
                        contentSize = 130.dp,
                        bottomCornerRadius = 30.dp,

                        )
                    Spacer(modifier = Modifier.weight(1f))
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 40.dp, start = 16.dp, end = 16.dp),
                    ) {
                        Spacer(modifier = Modifier.height(25.dp))
                        Text(
                            text = "Kamal Tyagi",
                            fontWeight = FontWeight.Bold,
                            fontFamily = Fonts.jostFontFamily,
                            fontSize = 24.sp,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        SkillvsmeText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navController.navigate(Route.Tutor.Profile.EditProfile)
                                },
                            value = "Edit Profile",
                            iconBeforeSize = 23.dp,
                            iconAfterSize = 20.dp,
                            fontSize = 20,
                            iconBeforeSpacer = 10.dp,
                            iconAfter = painterResource(id = R.drawable.arrow_forward),
                            iconBefore = painterResource(
                                id = R.drawable.edit,
                            )
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 10.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Divider(
                                color = darkGrey,
                                modifier = Modifier
                                    .height(1.dp)
                                    .fillMaxWidth() // Adjust width as needed
                            )
                        }
                        SkillvsmeText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navController.navigate(Route.Tutor.Profile.EditLanguage)
                                },
                            value = "Language",
                            value1 = "English",
                            iconBeforeSize = 20.dp,
                            iconAfterSize = 20.dp,
                            fontSize = 20,
                            iconBeforeSpacer = 10.dp,
                            iconAfter = painterResource(id = R.drawable.arrow_forward),
                            iconBefore = painterResource(
                                id = R.drawable.language__1_,
                            )
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 10.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Divider(
                                color = darkGrey,
                                modifier = Modifier
                                    .height(1.dp)
                                    .fillMaxWidth() // Adjust width as needed
                            )
                        }
                        SkillvsmeText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navController.navigate(Route.Tutor.Profile.Earnings)
                                },
                            value = "Earnings",
                            iconBeforeSize = 20.dp,
                            iconAfterSize = 20.dp,
                            fontSize = 20,
                            iconBeforeSpacer = 10.dp,
                            iconAfter = painterResource(id = R.drawable.arrow_forward),
                            iconBefore = painterResource(
                                id = R.drawable.balance,
                            )
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 10.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Divider(
                                color = darkGrey,
                                modifier = Modifier
                                    .height(1.dp)
                                    .fillMaxWidth() // Adjust width as needed
                            )
                        }
                        SkillvsmeText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navController.navigate(Route.Tutor.Profile.PaymentSettings)
                                },
                            value = "Payment setting",
                            iconBeforeSize = 20.dp,
                            iconAfterSize = 20.dp,
                            fontSize = 20,
                            iconBeforeSpacer = 10.dp,
                            iconAfter = painterResource(id = R.drawable.arrow_forward),
                            iconBefore = painterResource(
                                id = R.drawable.payment,
                            )
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 10.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Divider(
                                color = darkGrey,
                                modifier = Modifier
                                    .height(1.dp)
                                    .fillMaxWidth() // Adjust width as needed
                            )
                        }
                    }
                }
            },
            bottomBar = {
               BottomNavigation(navController = navController)
            }
        )
    }

}