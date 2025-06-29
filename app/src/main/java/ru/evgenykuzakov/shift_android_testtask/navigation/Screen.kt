package ru.evgenykuzakov.shift_android_testtask.navigation

sealed class Screen(val route: String) {
    object ShowUsersScreen: Screen(ROUTE_SHOW_USERS)
    object UserDetailInfoScreen: Screen(ARGS_ROUTE_USER_DETAIL_INFO){
        fun createRoute(userId: Int): String {
            return "$BASE_ROUTE_USER_DETAIL_INFO?userId=${userId}"
        }
    }

    companion object {
        private const val ROUTE_SHOW_USERS = "show_users"
        private const val BASE_ROUTE_USER_DETAIL_INFO = "user_detail_info"
        private const val ARGS_ROUTE_USER_DETAIL_INFO =
            "$BASE_ROUTE_USER_DETAIL_INFO?userId={userId}"
    }
}