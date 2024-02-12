package s.skillvsme.presentation.tutors

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import s.skillvsme.R
import s.skillvsme.presentation.tutors.components.TutorsDetailsAppBar
import s.skillvsme.ui.theme.black

@Composable
fun TutorsDetails() {
    Column {
        Column(
            modifier = Modifier
        ) {
            TutorsDetailsAppBar(
                name = "Alexander Brik",
                location = "California, USA",
                time = "6:30 PM",
                backgroundColor = black,
                backgroundImage = painterResource(id = R.drawable.top_blackish_bg),
                profileImage = painterResource(id = R.drawable.teacher),
                onClick = {}
            )
        }
    }
}