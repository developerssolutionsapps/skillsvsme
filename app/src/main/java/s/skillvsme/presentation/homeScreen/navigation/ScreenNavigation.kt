package s.skillvsme.presentation.homeScreen.navigation
import s.skillvsme.R
import s.skillvsme.common.Route

sealed class ScreenNavigation (var title :String,var icon :Int,var screenroute :String){
    object Home : ScreenNavigation("Home", R.drawable.home ,"/student/home")
    object Tutor : ScreenNavigation("Tutor", R.drawable.teachersvg,"/student/tutor/tutorslist")
    object Stream : ScreenNavigation("Stream",R.drawable.live_broadcasting,"/student/streaming/livestream")
    object Classes : ScreenNavigation("Classes",R.drawable.baseline_home_24,"/student/classes/upcomingclasses")
    object Account : ScreenNavigation("Account",R.drawable.account,"/student/profile/studentprofile")
}