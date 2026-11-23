package com.example.lebigo

data class DataForBinding(
    var resultatBas: Double? = null,
    var resultatHaut: Double? = null,
    val labelHaut: String? = null,
    val labelBas: String? = null
) {

    val resultatBasFormatted: String
        get() = String.format("%.2f", resultatBas ?: 0.0)

    val resultatHautFormatted: String
        get() = String.format("%.2f", resultatHaut ?: 0.0)
}