package com.mesh.pay.screens.explore

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mesh.pay.backend.database.SQLDatabaseConnection
import com.mesh.pay.backend.model.FundRequest
import com.mesh.pay.screens.explore.fundCallList

/**
 *
 */
@Composable
fun ExploreScreen(navController: NavController) {
    //fetchList


    val fundCallItems = listOf<FundRequest>(
        FundRequest(
            "Zugticket von Kiew nach Warschau",
            "6.03.22",
            7899,
            "UA21 3223 1300 0002 6007 2335 6600 1",
            "DE02 1203 0000 0000 2020 51",
            "DE02200505501015871393",
            89.99F,
            0,
            "Zugticket"

        ),
        FundRequest(
            "Semesterticket für das kommende Semester",
            "7.03.22",
            7899,
            "UA21 3223 1300 0002 6007 2335 6600 1",
            "DE02 1203 0000 0000 2020 51",
            "DE 0220 0505 5010 1587 1393",
            210.99F,
            0,
            "Zugticket"

        ),
        FundRequest(
        "Winterjacke",
        "11.03.22",
        7899,
        "UA21 3223 1300 0002 6007 2335 6600 1",
        "DE02 1203 0000 0000 2020 51",
        "DE02200505501015871393",
        44.99F,
        0,
        "Zugticket"

        ),

            FundRequest(
            "Monatsmiete, da meine Firma in Kurzarbeit ist",
            "10.03.22",
            7899,
            "UA21 3223 1300 0002 6007 2335 6600 1",
            "DE02 1203 0000 0000 2020 51",
            "DE02200505501015871393",
            44.99F,
            0,
            "Zugticket"

        )
    )
Column(Modifier.fillMaxSize()
    .padding(10.dp),
horizontalAlignment = Alignment.CenterHorizontally) {
    Text("Finde heraus, wo Du Deine ")
    Text("gute Tat für heute  ", fontWeight = FontWeight.Bold,)
    Text("vollbringen kannst ")
    Spacer(modifier = Modifier.requiredHeight(2.dp))
    val liste = SQLDatabaseConnection.abfrage()
    fundCallList(liste)
}

}