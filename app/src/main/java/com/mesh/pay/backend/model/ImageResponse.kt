package com.mesh.pay.backend.model

data class ImageResponse(
    val assetId	: Int,
    val previewImage: String,
    val raceGuid: String,
    val url: String,
    val vehicleImage: String
    )
