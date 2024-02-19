package s.skillvsme.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.greyishBlack
import s.skillvsme.ui.theme.white


@Composable
fun ReviewItem(){
    Column {
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Box(
                modifier = Modifier
                    .size(48.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rectangle4),
                    contentDescription = "",
                    modifier = Modifier.background(
                        white,
                        CircleShape
                    ),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                SkillvsmeText(
                    value = "Ali ben",
                    valueSize = 24
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SkillvsmeRatingBar()
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "14/09/2023",
                        fontWeight = FontWeight.Normal,
                        fontFamily = Fonts.jostFontFamily,
                        color = darkGrey
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        SkillvsmeText(value = "Highly satisfied with the English tutor's exceptional professionalism and expertise. Their teaching style effectively improved my language skills and boosted my confidence in English communication.")
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            thickness = 1.dp,
            color = darkGrey
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}