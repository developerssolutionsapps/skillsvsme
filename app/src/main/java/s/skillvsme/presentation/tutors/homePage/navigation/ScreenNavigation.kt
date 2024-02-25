package s.skillvsme.presentation.tutors.homePage.navigation

import s.skillvsme.R

sealed class ScreenNavigation (var title :String,var icon :Int,var screenroute :String){
    object Home : ScreenNavigation("Home", R.drawable.home ,"/tutor/home")
    object Tutorr : ScreenNavigation("Tutor", R.drawable.teachersvg,"/student/tutor/tutorslist")
    object Streamm : ScreenNavigation("Stream", R.drawable.live_broadcasting,"/student/streaming/livestream")
    object Classess : ScreenNavigation("Classes", R.drawable.schedule_1,"/student/classes/upcomingclasses")
    object Accounts : ScreenNavigation("Account", R.drawable.account,"/student/profile/studentprofile")
}