package com.example.testapp.presentation.ui.screens.userDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.testapp.domain.model.User
import com.example.testapp.presentation.ui.screens.helper.formatIsoDate


@Composable
fun UserDetailsContent(user: User) {
    // Show avatar large + at least 5 fields as requested
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = user.pictureLarge,
            contentDescription = "User photo",
            modifier = Modifier.size(160.dp)
        )

        LabeledValue("Full name", user.fullName)
        LabeledValue("Email", user.email)
        LabeledValue("Phone", user.phone)
        if (!user.cell.isNullOrBlank()) LabeledValue("Mobile", user.cell!!)
        if (!user.nat.isNullOrBlank()) LabeledValue("Nationality", user.nat!!)
        LabeledValue("Country", user.country)
        LabeledValue("Address", user.fullAddress)
        LabeledValue("Date of birth", formatIsoDate(user.dateOfBirthIso))
    }
}