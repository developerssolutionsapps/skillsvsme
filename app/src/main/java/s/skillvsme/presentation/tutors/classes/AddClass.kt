package s.skillvsme.presentation.tutors.classes

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import s.skillvsme.common.Fonts
import s.skillvsme.common.Route
import s.skillvsme.common.SetStatusBarColor
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.SkillvsmeButton
import s.skillvsme.presentation.components.datepicker
import s.skillvsme.presentation.components.timepicker
import s.skillvsme.presentation.tutors.components.TwoRadioButtons
import s.skillvsme.ui.theme.black
import s.skillvsme.ui.theme.purple
import s.skillvsme.ui.theme.white


@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddClass(
    navController: NavController
){
    SetStatusBarColor(color = white)
    var selectedOption by remember { mutableStateOf("Option 1") }
    val scrollstate= rememberScrollState()
    Scaffold (
        topBar = {
                SimpleAppBar(navController = navController, text = "Add Class")
        },
        content = {
            Column(modifier= Modifier
                .padding(20.dp)
                .fillMaxSize()
                .verticalScroll(scrollstate),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(80.dp))
                Column(
                    modifier=Modifier,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Pick a date",fontSize = 18.sp, fontFamily = Fonts.jostFontFamily, color = purple)
                    Spacer(modifier = Modifier.height(20.dp))
                    datepicker()
                    Spacer(modifier = Modifier.height(18.dp))
                    Text(text = "Pick time",fontSize = 18.sp, fontFamily = Fonts.jostFontFamily,color= purple)
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "From",fontSize = 18.sp, fontFamily = Fonts.jostFontFamily,color= black)
                    timepicker()
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "To")
                    timepicker()
                    Spacer(modifier = Modifier.height(8.dp))
                    TwoRadioButtons(
                        option1Text = "Repeat daily",
                        option2Text ="Repeat Weekly",
                        selectedOption =selectedOption ,
                        onOptionSelected = { option -> selectedOption = option },
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    SkillvsmeButton(
                        label = "Save",
                        modifier = Modifier.fillMaxWidth()
                    ){
                        navController.navigate(Route.Tutor.Classes.AddClassSuccess)
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    SkillvsmeButton(
                        label = "Cancel",
                        modifier = Modifier
                            .fillMaxWidth(),
                        primary = false,
                    ){
                        navController.popBackStack()
                    }
                    Spacer(modifier = Modifier.height(60.dp))
                }
            }
        }
    )
}