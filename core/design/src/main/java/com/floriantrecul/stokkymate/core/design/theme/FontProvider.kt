package com.floriantrecul.stokkymate.core.design.theme

import androidx.compose.ui.text.googlefonts.GoogleFont
import com.floriantrecul.stokkymate.design.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val roboto = GoogleFont("Roboto")
