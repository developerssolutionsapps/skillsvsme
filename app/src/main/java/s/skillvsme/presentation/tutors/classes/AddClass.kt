package s.skillvsme.presentation.tutors.classes

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import s.skillvsme.presentation.components.SimpleAppBar
import s.skillvsme.presentation.components.datepicker


@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Addclass(
    navController: NavController
){
    Scaffold (
        topBar = {
                SimpleAppBar(navController = navController, text = "Add Class")
        },
        content = {paddingValues ->
            Column(modifier= Modifier
                .padding(20.dp)
                .fillMaxSize()
            ) {
                Column(modifier=Modifier
                    .padding(paddingValues),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Pick a date")

                    datepicker()

                    Text(text = "Pick time")
                    Text(text = "From")
                    datepicker()
                    Text(text = "To")
                    datepicker()

                }
            }
        }
    )
}