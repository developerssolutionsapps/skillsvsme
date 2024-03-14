import android.R
import android.graphics.fonts.FontFamily
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import s.skillvsme.common.Fonts
import s.skillvsme.presentation.components.SkillvsmeBorderRadioBtn
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeRadioBtn
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.white

@Composable
fun ReportOverlay(value: String, setShowDialog: (Boolean) -> Unit, setValue: (String) -> Unit) {

    val txtFieldError = remember { mutableStateOf("") }
    val txtField = remember { mutableStateOf(value) }

    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = black,

            ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.Center
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Report Abuse", modifier = Modifier.padding(start = 50.dp),
                            fontFamily = Fonts.jostFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color.White)
                        Spacer(modifier = Modifier.weight(1f))
                        Image(
                            painter = painterResource(id = s.skillvsme.R.drawable.cancel),
                            contentDescription = "",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable { setShowDialog(false) }
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    SkillvsmeRadioBtn(modifier = Modifier.fillMaxWidth(),
                        selectedValue = "Unprofessional behaviour",
                        label = "Unprofessional behaviour", color = white,textColor = white,fontSize = 18)
                    SkillvsmeRadioBtn(modifier = Modifier.fillMaxWidth(),
                        selectedValue = "",
                        label = "Abusive/harmful content", color = white,textColor = white,fontSize = 18)
                    SkillvsmeRadioBtn(modifier = Modifier.fillMaxWidth(),
                        selectedValue = "",
                        label = "Misguidance", color = white,textColor = white,fontSize = 18)
                    SkillvsmeRadioBtn(modifier = Modifier.fillMaxWidth(),
                        selectedValue = "",
                        label = "Other", color = white, textColor = white, fontSize = 18)
                    SkillvsmeButton(
                        label = "Submit",
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp,top=10.dp)
                            .fillMaxWidth(),
                        primary = false
                    ){
                        setShowDialog(false)
                    }
                }
            }
        }
    }
}