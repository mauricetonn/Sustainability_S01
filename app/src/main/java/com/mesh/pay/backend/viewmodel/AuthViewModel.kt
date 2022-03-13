package com.mesh.pay.backend.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mesh.pay.backend.model.AuthResponse
import com.mesh.pay.backend.repository.AuthRepository
import com.mesh.pay.backend.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {
    var isLoading = mutableStateOf(false)
    private var _getAuthToken: MutableLiveData<AuthResponse> = MutableLiveData<AuthResponse>()
    var getAuthToken: LiveData<AuthResponse> = _getAuthToken

    suspend fun getAuthToken(field: String): Resource<AuthResponse> {
        val result = authRepository.getAuthToken(field)
        if (result is Resource.Success) {
            isLoading.value = true
            _getAuthToken.value = result.data!!
        }
        return result
    }
}