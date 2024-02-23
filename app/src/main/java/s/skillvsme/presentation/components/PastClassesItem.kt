package s.skillvsme.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import s.skillvsme.ui.theme.black60
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.white


@Composable
fun PastClassesItem(
    day: String,
    date: String,
    month: String,
    name: String,
    location: String,
    image: String,
    rating: Double,
    time: String,
    watchClicked: () -> Unit = {}
) {
    Row {
        DateCard(day = day, date = date, month = month)
        Spacer(modifier = Modifier.width(8.dp))
        BorderedSurface(
            borderWidth = 1.dp,
            background = white,
            cornerRadius = 16.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
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
                            value = name,
                            valueSize = 20
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                modifier = Modifier
                                    .padding(end = 8.dp),
                                painter = painterResource(R.drawable.location_black),
                                contentDescription = "location"
                            )
                            SkillvsmeText(
                                value = location,
                                boldValue = true,
                                valueSize = 10,
                                valueColor = black60
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = painterResource(R.drawable.rate_star), contentDescription = "rate star")
                        SkillvsmeText(
                            value = "$rating",
                            valueSize = 16
                        )
                    }
                    SkillvsmeText(
                        value = time,
                        valueSize = 16
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SkillvsmeButton(
                        label = "Watch",
                        modifier = Modifier.weight(1f),
                        onClick = watchClicked
                    )
                }
            }
        }
    }
}