package s.skillvsme.presentation.userprofilestudent

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.R
import s.skillvsme.common.Fonts
import s.skillvsme.presentation.components.EditTextLabel
import s.skillvsme.presentation.components.ProfileAppBar
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.components.SkillvsmeTextField
import s.skillvsme.ui.theme.darkGrey
import java.time.format.TextStyle

@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfile(
    navController: NavController
) {
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ProfileAppBar(
                    backgroundColor = Color.Black,
                    modifier = Modifier,
                    backgroundImage = painterResource(
                        id = R.drawable.rectangle5  ,
                    ),
                    contentSize = 130.dp,
                    bottomCornerRadius = 30.dp
                )
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp, start = 16.dp, end = 16.dp),
                ) {
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = "Kamal Tyagi",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    EditTextLabel(value = "Kamal Tyagi", text = "User Name")
                    Spacer(modifier = Modifier.height(15.dp))
                    EditTextLabel(value = "+999 45821365479", text = "Phone Number")

                    Spacer(modifier = Modifier.height(15.dp))
                    EditTextLabel(value = "Califonia, USA", text = "Location")

                    Spacer(modifier = Modifier.height(90.dp))
                    SkillvsmeButton(label = "Save Changes", modifier = Modifier.fillMaxWidth()) {
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    SkillvsmeText(
                        value = "Back",
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        boldLabel = false,
                        valueFont = FontWeight.Bold
                    )
                }
            }
        },
        bottomBar = {
            s.skillvsme.presentation.homeScreen.navigation.BottomNavigation(navController = navController)
        }
    )

}