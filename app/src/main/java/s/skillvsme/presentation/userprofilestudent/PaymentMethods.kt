package s.skillvsme.presentation.userprofilestudent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import s.skillvsme.R
import s.skillvsme.presentation.components.BorderedSurface
import s.skillvsme.presentation.components.ProfileAppBar

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun paymentMethod() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProfileAppBar(
            backgroundColor = Color.Black, modifier = Modifier, backgroundImage = painterResource(
                id = R.drawable.profile,
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
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Payment Methods", fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Primary")
            BorderedSurface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                background = Color.White,
                cornerRadius = 12.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp),

                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.payment),
                        contentDescription = "", modifier = Modifier
                            .padding(start = 15.dp, end = 10.dp)
                            .width(40.dp)
                            .height(30.dp)
                            .wrapContentSize()
                    )
                    Row(modifier = Modifier.wrapContentSize()) {
                        Column() {
                            Text(text = "XXXX-XXXX-XXXX-X456", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(text = "Expires 06/25", fontWeight = FontWeight.Light)
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "Remove",
                            modifier = Modifier.padding(end = 10.dp, top = 10.dp),
                            color = Color.Red,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Other")
            BorderedSurface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                background = Color.White,
                cornerRadius = 12.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp),

                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.payment),
                        contentDescription = "", modifier = Modifier
                            .padding(start = 15.dp, end = 10.dp)
                            .width(40.dp)
                            .height(30.dp)
                            .wrapContentSize()
                    )
                    Row(modifier = Modifier.wrapContentSize()) {
                        Column() {
                            Text(text = "XXXX-XXXX-XXXX-X456", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(text = "Expires 06/25", fontWeight = FontWeight.Light)
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "Remove",
                            modifier = Modifier.padding(end = 10.dp, top = 10.dp),
                            color = Color.Red,
                        )
                    }
                }
            }

            BorderedSurface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                background = Color.White,
                cornerRadius = 12.dp,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp),

                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.addition) ,
                        contentDescription = "", modifier = Modifier
                            .padding(start = 15.dp, end = 10.dp)
                            .size(30.dp)
                            .background(Color.Black, CircleShape)
                            .wrapContentSize()
                    )
                            Text(text = "Payment Method", fontWeight = FontWeight.Normal)
                }

            }
            Spacer(modifier = Modifier.height(40.dp))

        }
    }
}