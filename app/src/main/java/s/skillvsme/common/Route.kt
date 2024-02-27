package s.skillvsme.common

object Route {
    object Student {
        object Onboarding {
            const val SignUp = "/student/onboarding/signup"
            const val Onboarding1 = "/student/onboarding/onboarding1"
            const val Onboarding2 = "/student/onboarding/onboarding2"
            const val Onboarding3 = "/student/onboarding/onboarding3"
            const val JoinAS = "/student/onboarding/joinas"
            const val CodeVerification = "/student/onboarding/codeverification"
        }

        object Home {
            const val Home = "/student/home"
        }

        object Payment {
            const val CheckOut = "/student/payment/checkout"
            const val Payment = "/student/payment/payment"
            const val PaymentPlan = "/student/payment/paymentplan"
            const val PaymentSuccess = "/student/payment/paymentSuccess"
            const val BookTrial = "/student/payment/booktrial"
        }

        object Tutor {
            const val TutorsList = "/student/tutor/tutorslist"
            const val TutorProfile = "/student/tutor/tutorprofile"
            const val TutorVideo = "/student/tutor/tutorvideo"
            const val Schedule = "/student/tutor/schedule"
            const val AppointmentConfirmation = "/student/tutor/appointmentconfirmation"
        }

        object Classes {
            const val UpcomingClasses = "/student/classes/upcomingclasses"
            const val ClassCanceled = "/student/classes/classcanceled"
            const val ClassDetails = "/student/classes/classdetails"
            const val VideoScreen = "/student/classes/videoscreen"
            const val ClassRoom = "/student/classes/classroom"
        }

        object Profile {
            const val StudentProfile = "/student/profile/studentprofile"
            const val EditProfile = "/student/profile/editprofile"
            const val EditLanguage = "/student/profile/editlanguage"
            const val SubscriptionPlan = "/student/profile/subscriptionplan"
            const val PaymentMethods = "/student/profile/paymentmethods"
            const val Notifications = "/student/profile/notification"
        }

        object Streaming {
            const val LiveStream = "/student/streaming/livestream"
            const val ViewLiveStream = "/student/streaming/viewlivestream"

        }
    }

    object Tutor {
        object Home {
            const val Home = "/tutor/home"
        }
        object Profile {
            const val TutorProfile = "/tutor/profile/tutorprofile"
            const val EditProfile = "/tutor/profile/editprofile"
            const val EditLanguage = "/tutor/profile/editlanguage"
            const val Earnings = "/tutor/profile/subscriptionplan"
            const val PaymentSettings = "/tutor/profile/paymentsettings"
            const val Notifications = "/tutor/profile/notification"
            const val TransactionSuccess="/tutor/profile/transactionSuccess"
            const val TutorProfilePublicView="/tutor/profile/tutorProfilePublicView"
        }
        object Classes {
            const val UpcomingClasses = "/tutor/classes/upcomingclasses"
        }
        object Streaming {
            const val LiveStream = "/tutor/streaming/livestream"
            const val LiveStreamPreview = "/tutor/streaming/livestreampreview"

        }
    }

}