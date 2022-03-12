package com.mesh.pay.backend.model

/**
 * TODO: MAke sealed
 */
data class FundRequest(
    val beschreibenderText : String,
    val datum: String,
    val requestUUID : Int,
    val anfordererIBAN: String,
    val empfaengerIBAN: String,
    val bezahlerIBAN: String,
    val rechnungsBetrag: Float,
    val bezahlt: Boolean,
    val verwendungszweck: String,

    )
