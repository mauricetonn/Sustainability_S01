package com.mesh.pay.backend.repository

import com.mesh.pay.backend.utils.Resource
import com.mesh.pay.backend.model.ImageResponse
import com.mesh.pay.backend.network.ImageApiInterface
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ImageRepository @Inject constructor(
    private val imageApiInterface: ImageApiInterface
){
    /**
     * Function to get Image from MIC Backend
     *  @param token: Auth token
     *  @return Resource: loading, success or error.
     */
    suspend fun getImage(token: String): Resource<ImageResponse> {
        val response = try {
            imageApiInterface.getImage(token)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred: ${e.localizedMessage}")
        }
        return Resource.Success(response)
    }
}