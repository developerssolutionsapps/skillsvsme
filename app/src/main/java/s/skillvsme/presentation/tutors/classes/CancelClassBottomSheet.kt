package s.skillvsme.presentation.tutors.classes

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Route
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeRadioBtn
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.ui.theme.darkGrey
import s.skillvsme.ui.theme.red
import s.skillvsme.ui.theme.white

@Composable
fun CancelClassBottomSheet(navController: NavController) {
    SetStatusBarColor(color = white)
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
                                navController.popBackStack()
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
                    selectedValue = "Something agent came up",
                    label = "Something agent came up"
                )
                SkillvsmeRadioBtn(
                    modifier = Modifier,
                    selectedValue = "I booked by mistake",
                    label = "Technical issues"
                )
                SkillvsmeRadioBtn(
                    modifier = Modifier,
                    selectedValue = "I booked by mistake",
                    label = "Technical issues"
                )
                SkillvsmeRadioBtn(
                    modifier = Modifier,
                    selectedValue = "I booked by mistake",
                    label = "Technical issues"
                )
                SkillvsmeRadioBtn(
                    modifier = Modifier,
                    selectedValue = "I booked by mistake",
                    label = "Technical issues"
                )
                SkillvsmeRadioBtn(
                    modifier = Modifier,
                    selectedValue = "I booked by mistake",
                    label = "Technical issues"
                )
                SkillvsmeButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = "Cancel class",
                    onClick = {
                        navController.navigate(Route.Tutor.Classes.CancelClassSuccess)
                    }
                )
            }
        }
    }
}