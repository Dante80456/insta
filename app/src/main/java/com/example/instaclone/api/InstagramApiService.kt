package com.example.instaclone.api

import com.example.instaclone.models.InstagramResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InstagramApiService {
    // GET /users/{user-id}/media/recent/?access_token=ACCESS-TOKEN
    @GET("users/{user-id}/media/recent/")
    suspend fun getRecentMedia(
        @Path("user-id") userId: String,
        @Query("access_token") accessToken: String
    ): InstagramResponse
}
