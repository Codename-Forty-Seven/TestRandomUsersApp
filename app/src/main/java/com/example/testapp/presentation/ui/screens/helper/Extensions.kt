package com.example.testapp.presentation.ui.screens.helper

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone


fun formatIsoDate(iso: String): String {
    // Support common ISO formats returned by RandomUser (with/without millis, with 'Z' or offset)
    val inputPatterns = arrayOf(
        "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
        "yyyy-MM-dd'T'HH:mm:ss'Z'",
        "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
        "yyyy-MM-dd'T'HH:mm:ssXXX",
        "yyyy-MM-dd" // fallback if only date is present
    )

    val out = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).apply {
        // Show date in UTC to be stable regardless of device TZ
        timeZone = TimeZone.getTimeZone("UTC")
    }

    for (p in inputPatterns) {
        try {
            val inFmt = SimpleDateFormat(p, Locale.ENGLISH).apply {
                timeZone = TimeZone.getTimeZone("UTC")
            }
            val parsed = inFmt.parse(iso)
            if (parsed != null) return out.format(parsed)
        } catch (_: Exception) {
            // try next pattern
        }
    }
    // Fallback: show raw string if nothing matched
    return iso
}