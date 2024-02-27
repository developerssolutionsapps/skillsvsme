package s.skillvsme.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import s.skillvsme.common.Route
import s.skillvsme.presentation.student.classes.ClassDetails
import s.skillvsme.presentation.student.classes.ClassRoom
import s.skillvsme.presentation.student.classes.Classes
import s.skillvsme.presentation.student.classes.VideoScreen
import s.skillvsme.presentation.student.home.HomePage
import s.skillvsme.presentation.onboarding.CodeVerification
import s.skillvsme.presentation.onboarding.JoinAs
import s.skillvsme.presentation.onboarding.Onboarding1
import s.skillvsme.presentation.onboarding.Onboarding2
import s.skillvsme.presentation.onboarding.Onboarding3
import s.skillvsme.presentation.onboarding.Signup
import s.skillvsme.presentation.streaming.Streaming
import s.skillvsme.presentation.student.payment.BookTrial
import s.skillvsme.presentation.student.payment.Checkout
import s.skillvsme.presentation.student.payment.Payment
import s.skillvsme.presentation.student.payment.PaymentPlan
import s.skillvsme.presentation.student.payment.PaymentSuccess
import s.skillvsme.presentation.student.streaming.LiveStreaming
import s.skillvsme.presentation.student.classes.ClassCancelSuccess
import s.skillvsme.presentation.student.tutors.AppointmentConfirmationSuccess
import s.skillvsme.presentation.student.tutors.Schedule
import s.skillvsme.presentation.student.tutors.TutorsDetailsStud
import s.skillvsme.presentation.student.tutors.TutorsList
import s.skillvsme.presentation.tutors.TutorsProfile.Earnings
import s.skillvsme.presentation.tutors.notification.NotificationScreen
import s.skillvsme.presentation.tutors.TutorsProfile.PaymentSetting
import s.skillvsme.presentation.tutors.TutorsProfile.TransactionSuccess
import s.skillvsme.presentation.tutors.TutorsProfile.TutorProfile
import s.skillvsme.presentation.student.tutors.TutorsVideo
import s.skillvsme.presentation.tutors.home.TutorHomePage
import s.skillvsme.presentation.student.profile.EditLanguageStud
import s.skillvsme.presentation.student.profile.EditProfileStud
import s.skillvsme.presentation.student.profile.StudentProfile
import s.skillvsme.presentation.student.profile.SubscriptionPlan
import s.skillvsme.presentation.student.profile.paymentMethod
import s.skillvsme.presentation.tutors.streaming.StreamingScreen
import s.skillvsme.presentation.tutors.TutorsProfile.TutorsDetails
import s.skillvsme.presentation.tutors.classes.Addclass


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun NavigationGraph(navController: NavHostController, ) {
    var loginDetails by mutableStateOf(LoginDetails())

    NavHost(
        navController = navController,
        startDestination = Route.Student.Onboarding.Onboarding1
    ) {
        /*
        * The screens below are those that are related to both the students and the tutors.
        * The screens related to the student and tutors will follow later
        */
        // Onboarding screens
        composable(Route.Student.Onboarding.Onboarding1) {
            Onboarding1(navController = navController)
        }
        composable(Route.Student.Onboarding.Onboarding2) {
            Onboarding2(navController = navController)
        }
        composable(Route.Student.Onboarding.Onboarding3) {
            Onboarding3(navController = navController)
        }
        composable(Route.Student.Onboarding.JoinAS) {
            JoinAs(navController = navController, loginDetails = loginDetails)
        }
        composable(Route.Student.Onboarding.SignUp) {
            Signup(navController = navController)
        }
        composable(Route.Student.Onboarding.CodeVerification) {
            CodeVerification(navController = navController,loginDetails)
        }

        /*
        * Below are the screens related to the student only
        */
        // Home Screen
        composable(Route.Student.Home.Home) {
            HomePage(
                navController = navController
            )
        }

        // Payment
        composable(Route.Student.Payment.BookTrial) {
            BookTrial(navController = navController)
        }
        composable(Route.Student.Payment.CheckOut) {
            Checkout(navController = navController)
        }
        composable(Route.Student.Payment.Payment) {
            Payment(navController = navController)
        }
        composable(Route.Student.Payment.PaymentPlan) {
            PaymentPlan(navController = navController)
        }
        composable(Route.Student.Payment.PaymentSuccess) {
            PaymentSuccess(navController = navController)
        }

        // Classes
        composable(Route.Student.Classes.UpcomingClasses) {
            Classes(navController = navController)
        }
        composable(Route.Student.Classes.ClassRoom) {
            ClassRoom(navController = navController)
        }
        composable(Route.Student.Classes.ClassDetails) {
            ClassDetails(navController = navController)
        }
        composable(Route.Student.Classes.ClassCanceled) {
            ClassCancelSuccess(navController = navController)
        }
        composable(Route.Student.Classes.VideoScreen) {
            VideoScreen()
        }

        // Tutors
        composable(Route.Student.Tutor.TutorsList) {
            TutorsList(navController = navController)
        }
        composable(Route.Student.Tutor.TutorProfile){
            TutorsDetailsStud(navController = navController)
        }
        composable(Route.Student.Tutor.TutorVideo){
            TutorsVideo(navController = navController)
        }
        composable(Route.Student.Tutor.Schedule){
            Schedule(navController = navController)
        }
        composable(Route.Student.Tutor.AppointmentConfirmation){
            AppointmentConfirmationSuccess(navController = navController)
        }

        //Streaming
        composable(Route.Student.Streaming.LiveStream) {
            Streaming(navController)
        }
        composable(Route.Student.Streaming.ViewLiveStream) {
            LiveStreaming(navController)
        }

        // User account
        composable(Route.Student.Profile.StudentProfile) {
            StudentProfile(navController = navController)
        }
        composable(Route.Student.Profile.EditProfile) {
            EditProfileStud(navController)
        }
        composable(Route.Student.Profile.SubscriptionPlan) {
            SubscriptionPlan(navController)
        }
        composable(Route.Student.Profile.PaymentMethods) {
            paymentMethod(navController)
        }
        composable(Route.Student.Profile.Notifications) {
            NotificationScreen(navController)
        }
        composable(Route.Student.Profile.EditLanguage) {
            EditLanguageStud(navController)
        }

        /*
        * Below are the screens related to the student only
        */
        // Tutors home screen
        composable(Route.Tutor.Home.Home) {
            TutorHomePage(navController = navController)
        }

        // Tutors live stream screens
        composable(Route.Tutor.Streaming.LiveStream) {
            StreamingScreen(navController = navController)
        }
        composable(Route.Tutor.Streaming.LiveStreamPreview) {
            StreamingPreview(navController = navController)
        }

        // Tutors classes screens
        composable(Route.Tutor.Classes.Classes) {
            TutorsClassesScreen(navController = navController)
        }

        // Tutors profile screens
        composable(Route.Tutor.Profile.TutorProfile) {
            TutorProfile(navController = navController)
        }
        composable(Route.Tutor.Profile.EditLanguage) {
            EditLanguageStud(navController = navController)
        }
        composable(Route.Tutor.Profile.Earnings) {
            Earnings(navController = navController)
        }
        composable(Route.Tutor.Profile.EditProfile) {
            EditProfileStud(navController = navController)
        }
        composable(Route.Tutor.Profile.Notifications) {
            NotificationScreen(navController = navController)
        }
        composable(Route.Tutor.Profile.PaymentSettings) {
            PaymentSetting(navController = navController)
        }
        composable(Route.Tutor.Profile.TransactionSuccess) {
            TransactionSuccess(navController = navController)
        }
        composable(Route.Tutor.Profile.TutorProfilePublicView) {
            TutorsDetails(navController = navController)
        }

        //Tutor Classes
        composable(Route.Tutor.Classes.AddClass) {
            Addclass(navController = navController)
        }
    }
}
data class LoginDetails(
    var loginAsTutor: Boolean = false
){
    fun loginAsTutor(){
        loginAsTutor = true
    }
    fun loginAsStudents(){
        loginAsTutor = false
    }
}

