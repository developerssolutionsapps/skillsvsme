package s.skillvsme.presentation.homeScreen.navigation
import s.skillvsme.R

sealed class ScreenNavigation (var title :String,var icon :Int,var screenroute :String){
    object Home : ScreenNavigation("Home", R.drawable.home ,"/student/home")
    object Tutor : ScreenNavigation("Tutor", R.drawable.teachersvg,"/student/tutor")
    object Stream : ScreenNavigation("Stream",R.drawable.live_broadcasting,"student/stream/")
    object Classes : ScreenNavigation("Classes",R.drawable.baseline_home_24,"/student/classes")
    object Account : ScreenNavigation("Account",R.drawable.account,"/student/profile")
}