package com.example.profiletask.api
import com.example.profiletask.model.*
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("profile")
    fun getUserInfo(): Single<UserInfoResponse>

    @GET("home")
    fun getMediaInfo(): Single<MediaInfoResponse>
}
