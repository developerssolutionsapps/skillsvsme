package s.skillvsme.presentation.tutors

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import s.skillvsme.R
import s.skillvsme.presentation.components.TutorsListComponent
import s.skillvsme.ui.theme.black


@Composable
fun TutorsList() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        TutorsListComponent(
            name = "Alexander Brik",
            bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
            rating = 5.0,
            profile = painterResource(id = R.drawable.profile1)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            thickness = 1.dp,
            color = black
        )
        Spacer(modifier = Modifier.height(8.dp))
        TutorsListComponent(
            name = "Alexander Brik",
            bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
            rating = 4.8,
            profile = painterResource(id = R.drawable.profile2),
            isLive = false
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            thickness = 1.dp,
            color = black
        )
        Spacer(modifier = Modifier.height(8.dp))
        TutorsListComponent(
            name = "Alexander Brik",
            bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
            rating = 2.9,
            profile = painterResource(id = R.drawable.profile3),
            isLive = false
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            thickness = 1.dp,
            color = black
        )
        Spacer(modifier = Modifier.height(8.dp))
        TutorsListComponent(
            name = "Alexander Brik",
            bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
            rating = 4.5,
            profile = painterResource(id = R.drawable.profile1)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            thickness = 1.dp,
            color = black
        )
        Spacer(modifier = Modifier.height(8.dp))
        TutorsListComponent(
            name = "Alexander Brik",
            bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
            rating = 5.0,
            profile = painterResource(id = R.drawable.profile3)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            thickness = 1.dp,
            color = black
        )
        Spacer(modifier = Modifier.height(8.dp))
        TutorsListComponent(
            name = "Alexander Brik",
            bio = "Experienced and dedicated language tutor passionate about helping students unlock their linguistic potential. Skilled in ...",
            rating = 4.2,
            profile = painterResource(id = R.drawable.profile2),
            isLive = false
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            thickness = 1.dp,
            color = black
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}