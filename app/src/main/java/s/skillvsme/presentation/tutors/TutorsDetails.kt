package s.skillvsme.presentation.tutors

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.R
import s.skillvsme.presentation.tutors.components.TutorsDetailsAppBar
import s.skillvsme.ui.theme.black

@Composable
fun TutorsDetails() {
    Column {
        Column(
            modifier = Modifier
        ) {
            // Tutors details app bar
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.rate_star), contentDescription = "rate star")
                Text(text = "5.0", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .height(32.dp),
                thickness = 1.dp
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "45+", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = "hrs", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .height(32.dp),
                thickness = 1.dp
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "155+", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = "classes", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            Divider(
                modifier = Modifier
                    .width(1.dp)
                    .height(32.dp),
                thickness = 1.dp
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(30.dp),
                    painter = painterResource(id = R.drawable.video),
                    contentDescription = "rate star"
                )
                Text(text = "watch", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        }
    }
}