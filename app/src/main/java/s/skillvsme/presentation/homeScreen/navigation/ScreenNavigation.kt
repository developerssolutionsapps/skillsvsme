package s.skillvsme.presentation.homeScreen.navigation
import s.skillvsme.R

sealed class ScreenNavigation (var title :String,var icon :Int,var screen_route :String){
    object Home : ScreenNavigation("Home", R.drawable.home ,"/home")
    object Tutor : ScreenNavigation("Tutor", R.drawable.teacher,"/students/details")
    object Stream : ScreenNavigation("Stream",R.drawable.live_broadcasting,"/profile/edit")
    object Classes : ScreenNavigation("Classes",R.drawable.baseline_home_24,"/profile/edit")
    object Account : ScreenNavigation("Account",R.drawable.account,"/profile/edit")
}