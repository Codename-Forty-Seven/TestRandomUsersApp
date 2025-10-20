package com.example.testapp.presentation.ui.screens.userDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight


@Composable
fun LabeledValue(label: String, value: String) {
    // Tiny helper to keep details consistent
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(label, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.SemiBold)
        Text(value, style = MaterialTheme.typography.bodyLarge)
    }
}