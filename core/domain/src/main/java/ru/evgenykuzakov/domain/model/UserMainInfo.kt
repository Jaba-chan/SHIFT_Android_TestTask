package ru.evgenykuzakov.domain.model

data class UserMainInfo(
    val name: Name,
    val picture: PictureMedium,
    val location: LocationMainInfo,
    val email: String,
)

data class LocationMainInfo(
    val street: Street,
    val city: String,
    val country: String,
)

data class PictureMedium(
    val medium: String,
)