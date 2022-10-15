package com.example.finalaplikasigithubuser

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<ListUserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getDetailUsers(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ): Call<List<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ): Call<List<User>>
}