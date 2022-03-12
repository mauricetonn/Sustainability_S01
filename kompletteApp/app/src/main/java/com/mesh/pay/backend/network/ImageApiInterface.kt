package com.mesh.pay.backend.network

import com.mesh.pay.backend.model.ImageResponse
import retrofit2.http.Header
import retrofit2.http.POST
import javax.inject.Singleton

/**
 * Calling Emotional Assets API
 */
@Singleton
interface ImageApiInterface {
    @POST("/asset")
    suspend fun getImage(@Header("Authorization") token : String): ImageResponse
}