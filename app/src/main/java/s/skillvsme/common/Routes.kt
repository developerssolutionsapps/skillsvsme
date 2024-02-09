package s.skillvsme.common

object Route {
    object Onboarding {
        const val SignUp = "/onboarding/signup"
        const val SignIn = "/onboarding/signin"
        const val ForgotPassword = "/onboarding/forgot_password"
    }
    object Home {
        const val Home = "/home"
        const val Notifications = "/home/notifications"
    }

    object Profile {
        const val Root = "/profile/root"
        const val Home = "/profile"
        const val EditProfile = "/profile/edit"
    }
}