package com.mesh.pay.backend.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mesh.pay.backend.model.ImageResponse
import com.mesh.pay.backend.repository.ImageRepository
import com.mesh.pay.backend.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    private val imageRepository: ImageRepository
): ViewModel() {
    var isLoading = mutableStateOf(false)
    private var _getImage: MutableLiveData<ImageResponse> = MutableLiveData<ImageResponse>()
    var getImage: LiveData<ImageResponse> = _getImage

    suspend fun getImage(token: String): Resource<ImageResponse> {
        val result = imageRepository.getImage(token)
        if (result is Resource.Success) {
            isLoading.value = true
            _getImage.value = result.data!!
        }

        return result
    }
}