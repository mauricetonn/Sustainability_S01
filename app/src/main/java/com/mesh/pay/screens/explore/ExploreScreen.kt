package com.mesh.pay.screens.explore

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
            "21.03.22",
            7899,
            "UA21 3223 1300 0002 6007 2335 6600 1",
            "DE02120300000000202051",
            "DE02200505501015871393",
            90.0F,
            0,
            "Zugticket"

        ),
        FundRequest(
            "Semesterticket für das kommende Semester",
            "21.03.22",
            7899,
            "UA21 3223 1300 0002 6007 2335 6600 1",
            "DE02120300000000202051",
            "DE02200505501015871393",
            210.99F,
            0,
            "Zugticket"

        ),
        FundRequest(
        "Wintejacke",
        "21.03.22",
        7899,
        "UA21 3223 1300 0002 6007 2335 6600 1",
        "DE02120300000000202051",
        "DE02200505501015871393",
        44.99F,
        0,
        "Zugticket"

    ) ,

        FundRequest(
        "Monatsmiete, da meine Firma in Kurzarbeit ist",
        "21.03.22",
        7899,
        "UA21 3223 1300 0002 6007 2335 6600 1",
        "DE02120300000000202051",
        "DE02200505501015871393",
        44.99F,
        0,
        "Zugticket"

    )
    )
Column(Modifier.fillMaxSize()
    .padding(10.dp),
horizontalAlignment = Alignment.CenterHorizontally) {
    Text("Finde heraus, wo du deine ")
    Text("gute Tat für heute  ", fontWeight = FontWeight.Bold,)
    Text("vollbringen kannst ")
    Spacer(modifier = Modifier.requiredHeight(2.dp))
    fundCallList(fundCallItems)
}

}