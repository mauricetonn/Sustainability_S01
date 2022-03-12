package com.mesh.pay.backend.repository

import com.mesh.pay.backend.utils.Resource
import com.mesh.pay.backend.model.AuthResponse
import com.mesh.pay.backend.network.AuthApiInterface
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class AuthRepository @Inject constructor(
    private val authApiInterface: AuthApiInterface
){

    /**
     * Function to get Token
     *  @param field that needs to be passed for REST call containing client ID
     * @return Resource: loading, success or error.
     */
    suspend fun getAuthToken(field: String): Resource<AuthResponse> {
        val response = try {
            authApiInterface.postToken(field)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred: ${e.localizedMessage}")
        }

        return Resource.Success(response)
    }
}