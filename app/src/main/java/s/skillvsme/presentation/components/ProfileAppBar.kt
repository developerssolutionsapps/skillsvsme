package s.skillvsme.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import s.skillvsme.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileAppBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    backgroundImage: Painter? = null,
    contentSize: Dp = 180.dp,
    bottomCornerRadius: Dp = 30.dp,
    scope:CoroutineScope?=null,
    bottomSheetScaffoldState:BottomSheetScaffoldState?=null,
    navController:NavController?=null,
    cameraIconAvailable:Boolean=false,
    backNavigationAction: (() -> Unit)? = null

    ) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(contentSize)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(
                    bottomEnd = bottomCornerRadius,
                    bottomStart = bottomCornerRadius,
                )
            )

    ) {
        Image(
            painter = painterResource(id = R.drawable.background_lines),
            contentDescription = "Vehicles Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(contentSize),
            contentScale = ContentScale.Crop
        )

        // Circle Image View
        Box(
            modifier = Modifier
                .graphicsLayer {
                    translationY = +55.dp.toPx()
                }
                .size(131.dp)
                .background(Color.Transparent, CircleShape)
                .align(Alignment.BottomCenter)
        ) {

            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .border(border = BorderStroke(8.dp, Color.Black), shape = CircleShape),
                shape = CircleShape
            ) {
                if (backgroundImage != null) {
                    Image(
                        painter = backgroundImage,
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            if(cameraIconAvailable){
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .graphicsLayer {
                            translationY = -4.dp.toPx()
                        }
                        .align(Alignment.BottomEnd)
                        .background(color = Color.Black, CircleShape)
                        .clickable {
                            scope?.launch {
                                bottomSheetScaffoldState?.bottomSheetState?.expand()
                            }
                        }
                ) {
                    Image(
                            painter = painterResource(id = R.drawable.camera),
                        contentDescription = "",
                        modifier = Modifier
                            .background(Color.Black, CircleShape)
                            .size(30.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.arrowback),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp, top = 40.dp)
                .size(40.dp)
                .clickable {
                    if (backNavigationAction != null) {
                        backNavigationAction()
                    } else {
                        navController?.popBackStack()
                    }
                }
        )
    }
}
