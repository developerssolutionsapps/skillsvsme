package s.skillvsme.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.white

@Composable
fun CustomDialog(
    value: String,
    setShowDialog: (Boolean) -> Unit,
    buttonText: String,
    buttonAction: () -> Unit = {}
) {
    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(25.dp),
            color = black
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(21.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(50),
                            color = white
                        ) {
                            Image(
                                modifier = Modifier
                                    .padding(4.dp),
                                painter = painterResource(id = R.drawable.cancel),
                                contentDescription = null
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(21.dp))
                    Text(
                        text = value,
                        fontSize = 18.sp,
                        fontFamily = Fonts.jostFontFamily,
                        color = white
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                        SkillvsmeButton(
                            primary = false,
                            label = buttonText,
                            onClick = {
                                setShowDialog(false)
                            }
                        )
                    }
                }
            }
        }
    }
}