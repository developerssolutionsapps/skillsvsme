package s.skillvsme.presentation.student.classes

import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.ui.theme.black

@Composable
fun ClassRoom(
    navController: NavController
) {
    val density = LocalDensity.current
    val statusBarHeight = with(density) { remember { WindowInsetsCompat.Type.statusBars() } }
    val navigationBarHeight = with(density) { remember { WindowInsetsCompat.Type.navigationBars() } }

    Column(
        modifier = Modifier
            .padding(bottom = navigationBarHeight.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.TopEnd
        ){
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.tutor),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Image(
                modifier = Modifier
                    .padding(top = navigationBarHeight.dp)
                    .size(24.dp)
                    .padding(end = 20.dp, top = 20.dp),
                painter = painterResource(id = R.drawable.minimize),
                contentDescription = null,
            )
        }
        Box(
            modifier = Modifier
                .weight(1.14f),
            contentAlignment = Alignment.BottomCenter
        ){
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.student),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .wrapContentHeight()
            ){
                Surface(
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                    color = black,
                    modifier = Modifier
                        .wrapContentHeight(),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Box(
                            modifier = Modifier
                                .height(35.dp)
                                .width(24.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.keyboard_arrow_top),
                                contentDescription = null
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 33.dp, top = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier.size(48.dp),
                                painter = painterResource(id = R.drawable.video_recorder),
                                contentDescription = null
                            )
                            Image(
                                modifier = Modifier.size(48.dp),
                                painter = painterResource(id = R.drawable.audio_recorder),
                                contentDescription = null
                            )
//                    Column {
                            Image(
                                modifier = Modifier.size(56.dp),
                                painter = painterResource(id = R.drawable.cancel_call),
                                contentDescription = null
                            )
//                    }
                            Image(
                                modifier = Modifier.size(48.dp),
                                painter = painterResource(id = R.drawable.mute),
                                contentDescription = null
                            )
                            Image(
                                modifier = Modifier.size(48.dp),
                                painter = painterResource(id = R.drawable.chat),
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}