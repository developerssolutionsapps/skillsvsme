package s.skillvsme.common

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import s.skillvsme.R

object Fonts {
    val jostFontFamily = FontFamily(
        Font(R.font.jost_regular),
        Font(R.font.jost_bold, FontWeight.Bold),
        Font(R.font.jost_semibold, FontWeight.SemiBold),
        Font(R.font.jost_light, FontWeight.Light),
        Font(R.font.jost_medium, FontWeight.Medium),
        Font(R.font.jost_thin, FontWeight.Thin),
        Font(R.font.jost_extralight, FontWeight.ExtraLight),
        Font(R.font.jost_extrabold, FontWeight.ExtraBold),
        Font(R.font.jost_black, FontWeight.Black),
    )

    val headlandOneFontFamily = FontFamily(
        Font(R.font.headlandone_regular),
    )
}