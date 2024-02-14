package s.skillvsme.presentation.userprofilestudent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.R
import s.skillvsme.presentation.components.ProfileAppBar
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.SkillvsmeText
import s.skillvsme.presentation.components.SkillvsmeTextField

@Composable
fun EditProfile() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProfileAppBar(
            backgroundColor = Color.Black, modifier = Modifier, backgroundImage = painterResource(
                id = R.drawable.rectangle4,
            ), contentSize = 130.dp, bottomCornerRadius = 30.dp
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
            Spacer(modifier = Modifier.height(20    .dp))
            SkillvsmeTextField(value = "Kamal Tyagi", onChange ={} , label = "User Name", hint ="", fieldDescription = "" , boldLabel = false) {
                
            }
            Spacer(modifier = Modifier.height(20    .dp))
            SkillvsmeTextField(value = "+999 45821365479", onChange ={} , label = "Phone Number", hint ="", fieldDescription = "", boldLabel = false ) {

            }
            Spacer(modifier = Modifier.height(20.dp))
            SkillvsmeTextField(value = "Califonia, USA", onChange ={} , label = "Location", hint ="", fieldDescription = "" , boldLabel = false) {
            }
            Spacer(modifier = Modifier.height(90.dp))
            SkillvsmeButton(label = "Save Changes", modifier = Modifier.fillMaxWidth()) {
            }
            Spacer(modifier = Modifier.height(20.dp))
            SkillvsmeText(value = "Back", modifier = Modifier.align(Alignment.CenterHorizontally), boldLabel = false, valueFont = FontWeight.Bold)
        }
    }
}