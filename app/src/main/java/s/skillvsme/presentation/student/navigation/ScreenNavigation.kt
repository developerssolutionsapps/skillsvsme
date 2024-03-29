package s.skillvsme.presentation.student.navigation
import s.skillvsme.R

sealed class ScreenNavigation (var title :String,var icon :Int,var screenroute :String){
    object Home : ScreenNavigation("Home", R.drawable.home ,"/student/home")
    object Tutor : ScreenNavigation("Tutor", R.drawable.teachersvg,"/student/tutor/tutorslist")
    object Stream : ScreenNavigation("Stream",R.drawable.live_broadcasting,"/student/streaming/viewlivestream")
    object Classes : ScreenNavigation("Classes",R.drawable.schedule_1,"/student/classes/upcomingclasses")
    object Account : ScreenNavigation("Account",R.drawable.account,"/student/profile/studentprofile")
}