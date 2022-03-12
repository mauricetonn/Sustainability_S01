package com.mesh.pay.backend.model

data class AuthResponse(
    val access_token : String,
    val token_type: String,
    val expires_in : Int,
    val id_token: String
)
