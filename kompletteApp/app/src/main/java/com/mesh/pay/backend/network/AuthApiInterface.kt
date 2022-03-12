package com.mesh.pay.backend.network

import com.mesh.pay.backend.model.AuthResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import javax.inject.Singleton


@Singleton
interface AuthApiInterface {
    @FormUrlEncoded
    @POST("/token")
    suspend fun postToken(@Field("field") field : String): AuthResponse
}