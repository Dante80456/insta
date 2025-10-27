package com.example.instaclone.models

data class InstagramResponse(
    val data: List<InstagramPhoto>
)

data class InstagramPhoto(
    val id: String?,
    val images: InstagramImageSet?,
    val user: InstagramUser?
)

data class InstagramImageSet(
    val standard_resolution: InstagramImage?
)

data class InstagramImage(
    val url: String?,
    val width: Int?,
    val height: Int?
)

data class InstagramUser(
    val id: String?,
    val username: String?,
    val profile_picture: String?
)
