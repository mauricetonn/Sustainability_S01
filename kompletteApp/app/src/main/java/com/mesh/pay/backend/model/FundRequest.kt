package com.mesh.pay.backend.model

/**
 * TODO: MAke sealed
 */
data class FundRequest(
    val beschreibendertext : String,
    val datum: String,
    val requestuuid : Int,
    val anfordereriban: String,
    val empfaengeriban: String,
    val bezahleriban: String,
    val rechnungsbetrag: Float,
    val bezahlt: Int,
    val verwendungszweck: String,

    )
