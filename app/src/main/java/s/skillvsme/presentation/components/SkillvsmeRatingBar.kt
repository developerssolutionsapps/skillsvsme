package s.skillvsme.presentation.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import s.skillvsme.R

@Composable
fun SkillvsmeRatingBar() {
    Row(){
        repeat(5){
            Box(
                modifier = Modifier
                    .height(12.dp)
                    .width(14.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star_full),
                    contentDescription = "star",
                    modifier = Modifier
                        .padding(horizontal = 1.dp)
                )
            }
        }
    }
}