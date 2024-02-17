package s.skillvsme.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import s.skillvsme.R
import s.skillvsme.ui.theme.darkGrey

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(iconCamera:Int,iconGallery:Int,iconAvatar:Int,iconDelete:Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkGrey.copy(alpha = 0.2f)),
        contentAlignment = Alignment.BottomCenter
    ){
        Card(
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            backgroundColor = Color.White,
            elevation = 8.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomSheetItem(
                    icon =iconGallery,
                    onClick = {  }
                )
                BottomSheetItem(
                    icon = iconGallery,
                    onClick = {  }
                )
                BottomSheetItem(
                    icon = iconAvatar,
                    onClick = {  }
                )
                BottomSheetItem(
                    icon = iconDelete,
                    onClick = {  }
                )
            }
        }
    }

}

@Composable
fun BottomSheetItem(icon: Int, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null
        )
    }
}