package s.skillvsme.presentation.tutors.navigation

import s.skillvsme.R

sealed class ScreenNavigation (var title :String,var icon :Int,var screenroute :String){
    object Home : ScreenNavigation("Home", R.drawable.home ,"/tutor/home")
    object Stream : ScreenNavigation("Stream", R.drawable.live_broadcasting,"/tutor/streaming/livestreampreview")
    object Classess : ScreenNavigation("Classes", R.drawable.schedule_1,"/tutor/classes/classes")
    object Accounts : ScreenNavigation("Account", R.drawable.account,"/tutor/profile/tutorprofile")
}