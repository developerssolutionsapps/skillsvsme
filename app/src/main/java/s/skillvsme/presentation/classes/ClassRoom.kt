package s.skillvsme.presentation.classes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.R

@Composable
fun ClassRoom(
    navController: NavController
) {
    Column {
        Box(
            modifier = Modifier
                .weight(4f)
        ){
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.tutor),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Box(
            modifier = Modifier
                .weight(4f)
        ){
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.tutor),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Box(
            modifier = Modifier
                .weight(2f)
        ){
            Card(
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                backgroundColor = Color.White,
                elevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(id = R.drawable.video_recorder), contentDescription = null)
                    Image(painter = painterResource(id = R.drawable.audio_recorder), contentDescription = null)
                    Image(painter = painterResource(id = R.drawable.cancel_call), contentDescription = null)
                    Image(painter = painterResource(id = R.drawable.mute), contentDescription = null)
                    Image(painter = painterResource(id = R.drawable.chat), contentDescription = null)
                }
            }
        }
    }
}