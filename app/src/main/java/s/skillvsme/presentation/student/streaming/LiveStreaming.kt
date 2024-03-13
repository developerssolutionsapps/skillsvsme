package s.skillvsme.presentation.student.streaming

import ReportOverlay
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeLiveTag
import s.skillvsme.presentation.dialog.PopForFollow
import s.skillvsme.presentation.onboarding.noRippleClickable
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.white
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun LiveStreaming(
    navController: NavController
) {
    SetStatusBarColor(color = Color(0x33597041))
    val scope = rememberCoroutineScope()
    var following by remember { mutableStateOf(false) }
    val muted = remember { mutableStateOf(false) }
    val showDialog = remember { mutableStateOf(false) }
    var showDialogPop by remember { mutableStateOf(false) }
    var dialogLaunched by remember { mutableStateOf(false) }
    if (!dialogLaunched) {
        scope.launch {
            delay(5000)
            if(!following){
                showDialogPop = true
                dialogLaunched = true
            }
        }
    }
    if (showDialog.value)
        ReportOverlay(value = "", setShowDialog = {
            showDialog.value = it
        }) {}
    if (showDialogPop)
        PopForFollow(
            value = "",
            setShowDialog = {
                showDialogPop = it
            },
            following = {
                following = it
            }
        )
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
            GiftOverlay(
                navController = navController,
                cancelClicked = {
                    scope.launch {
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
            content = { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.student),
                        contentDescription = null
                    )
                    Column(
                        modifier = Modifier
                            .padding(paddingValues)
                            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 20.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(65.dp),
                                    contentAlignment = Alignment.BottomCenter
                                ) {
                                    Surface(
                                        modifier = Modifier
                                            .size(65.dp),
                                        shape = RoundedCornerShape(percent = 50)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.student),
                                            contentDescription = "",
                                            modifier = Modifier.background(
                                                white,
                                                CircleShape
                                            ),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    SkillvsmeLiveTag(
                                        fontSize = 10,
                                        textModifier = Modifier
                                            .padding(horizontal = 8.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(20.dp))
                                Column(
                                    verticalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Row {
                                        Text(
                                            text = "Keria Swain",
                                            fontWeight = FontWeight.SemiBold,
                                            fontFamily = Fonts.jostFontFamily,
                                            color = white,
                                            fontSize = 20.sp
                                        )
                                        Spacer(modifier = Modifier.width(20.dp))
                                        if(!following) {
                                            Image(
                                                painter = painterResource(id = R.drawable.follow_1),
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .size(24.dp)
                                                    .clickable {
                                                        following = true
                                                    }
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(8.dp),
                                            color = black
                                        ) {
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceEvenly,
                                                modifier = Modifier
                                                    .height(22.dp)
                                                    .padding(start = 2.dp, end = 9.dp)
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.followers),
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size(24.dp)
                                                )
                                                Text(
                                                    text = "1996",
                                                    fontWeight = FontWeight.Bold,
                                                    fontFamily = Fonts.jostFontFamily,
                                                    fontSize = 12.sp
                                                )
                                            }
                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Surface(
                                            shape = RoundedCornerShape(8.dp),
                                            color = black
                                        ) {
                                            if(following) {
                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                                    modifier = Modifier
                                                        .height(22.dp)
                                                ) {
                                                    Text(
                                                        modifier = Modifier
                                                            .padding(start = 13.dp, end = 14.dp),
                                                        text = "following",
                                                        fontWeight = FontWeight.Normal,
                                                        fontFamily = Fonts.jostFontFamily,
                                                        fontSize = 10.sp
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            Surface(
                                modifier = Modifier
                                    .size(30.dp),
                                shape = RoundedCornerShape(percent = 50),
                                color = black
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.close),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .clickable {
                                            navController.popBackStack()
                                        }
                                        .size(24.dp)
                                        .padding(4.dp)
                                )
                            }
                        }
                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth(),
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Bottom,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 20.dp)
                            ) {
                                StreamingChat(
                                    name = "Sally Ed",
                                    text = "Hello there"
                                )
                                StreamingChat(
                                    name = "Cid Park",
                                    text = "I was waiting for this live.."
                                )
                                StreamingChat(
                                    name = "Fatima Adel",
                                    text = "Your video is super hel..."
                                )
                                StreamingChat(
                                    name = "Anne Wayte",
                                    text = "Very nice"
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Row(
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .weight(1f, fill = false)
                                ) {
                                    OutlinedTextField(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(TextFieldDefaults.MinHeight),
                                        value = "",
                                        colors = TextFieldDefaults.textFieldColors(
                                            containerColor = black,
                                        ),
                                        shape = RoundedCornerShape(40),
                                        onValueChange = {},
                                        placeholder = {
                                            Text(
                                                modifier = Modifier
                                                    .weight(1f),
                                                text = "Write a comment",
                                                fontFamily = Fonts.jostFontFamily,
                                                fontSize = 18.sp,
                                                color = white
                                            )
                                        },
                                        trailingIcon = {
                                            Image(
                                                painter = painterResource(id = R.drawable.send),
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .size(48.dp)
                                                    .padding(end = 4.dp, bottom = 4.dp)
                                            )
                                        }
                                    )
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .wrapContentWidth()
                            ) {
                                if(!muted.value) {
                                    Image(
                                        painter = painterResource(id = R.drawable.unmute),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .noRippleClickable {
                                                muted.value = true
                                            }
                                            .size(48.dp)
                                    )
                                } else {
                                    Image(
                                        painter = painterResource(id = R.drawable.muted),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .noRippleClickable {
                                                muted.value = false
                                            }
                                            .size(48.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.warning),
                                    contentDescription = null, modifier = Modifier.clickable {
                                        showDialog.value = true
                                    }
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.user2),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .clickable {
                                            navController.navigate(Route.Student.Tutor.TutorProfile)
                                        }
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Image(
                                    modifier = Modifier
                                        .clickable {
                                           scope.launch {
                                               bottomSheetScaffoldState.bottomSheetState.expand()
                                           }
                                        },
                                    painter = painterResource(id = R.drawable.gift),
                                    contentDescription = null
                                )
                            }
                        }
                    }
                }
            },
        )
    }
}

@Composable
fun StreamingChat(
    name: String,
    text: String
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val randomColor = Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        Surface(
            modifier = Modifier
                .size(40.dp),
            shape = RoundedCornerShape(20.dp),
            color = randomColor
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = name.first().toString(),
                    fontFamily = Fonts.jostFontFamily,
                    fontSize = 24.sp,
                    color = white
                )
            }
        }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 8.dp, vertical = 4.dp),
            shape = RoundedCornerShape(16.dp),
            color = black.copy(alpha = 0.3f)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = name,
                    fontFamily = Fonts.jostFontFamily,
                    fontSize = 14.sp,
                    color = white,
                    maxLines = 1
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = text,
                    fontFamily = Fonts.jostFontFamily,
                    fontSize = 14.sp,
                    color = white,
                    maxLines = 1
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GiftOverlay(navController: NavController, cancelClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(418.dp)
            .background(darkGrey.copy(alpha = 0.2f)),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            color = black
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Appreciate",
                        color = white,
                        fontFamily = Fonts.jostFontFamily,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        modifier = Modifier
                            .clickable {
                                cancelClicked()
                            },
                        painter = painterResource(id = R.drawable.cancel),
                        contentDescription = null
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Column(
                    modifier = Modifier.padding(horizontal = 45.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(48.dp),
                                painter = painterResource(id = R.drawable.coin_1),
                                contentDescription = null
                            )
                            Text(
                                text = "Coin",
                                color = white,
                                fontFamily = Fonts.jostFontFamily,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "5₹",
                                color = white,
                                fontFamily = Fonts.jostFontFamily,
                                fontSize = 14.sp
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(48.dp),
                                painter = painterResource(id = R.drawable.heart),
                                contentDescription = null
                            )
                            Text(
                                text = "Heart",
                                color = white,
                                fontFamily = Fonts.jostFontFamily,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "10₹",
                                color = white,
                                fontFamily = Fonts.jostFontFamily,
                                fontSize = 14.sp
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(48.dp),
                                painter = painterResource(id = R.drawable.rose),
                                contentDescription = null
                            )
                            Text(
                                text = "Rose",
                                color = white,
                                fontFamily = Fonts.jostFontFamily,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "20₹",
                                color = white,
                                fontFamily = Fonts.jostFontFamily,
                                fontSize = 14.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(17.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(48.dp),
                                painter = painterResource(id = R.drawable.chocolate),
                                contentDescription = null
                            )
                            Text(
                                text = "Chocolate",
                                color = white,
                                fontFamily = Fonts.jostFontFamily,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "50₹",
                                color = white,
                                fontFamily = Fonts.jostFontFamily,
                                fontSize = 14.sp
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(48.dp),
                                painter = painterResource(id = R.drawable.gold_ingot),
                                contentDescription = null
                            )
                            Text(
                                text = "Gold",
                                color = white,
                                fontFamily = Fonts.jostFontFamily,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "75₹",
                                color = white,
                                fontFamily = Fonts.jostFontFamily,
                                fontSize = 14.sp
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(48.dp),
                                painter = painterResource(id = R.drawable.diamond),
                                contentDescription = null
                            )
                            Text(
                                text = "Diamond",
                                color = white,
                                fontFamily = Fonts.jostFontFamily,
                                fontSize = 14.sp
                            )
                            Text(
                                text = "100₹",
                                color = white,
                                fontFamily = Fonts.jostFontFamily,
                                fontSize = 14.sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(27.dp))
                SkillvsmeButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = "Send Gift",
                    primary = false
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Current Balance: 150$ ",
                        color = white,
                        fontFamily = Fonts.jostFontFamily,
                        fontSize = 14.sp
                    )
                    Text(
                        modifier = Modifier
                            .clickable { },
                        text = "Recharge",
                        color = white,
                        fontFamily = Fonts.jostFontFamily,
                        fontSize = 14.sp,
                        textDecoration = TextDecoration.Underline
                    )
                }
                Spacer(modifier = Modifier.height(51.dp))
            }
        }
    }
}