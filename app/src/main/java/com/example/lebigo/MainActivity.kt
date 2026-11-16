package com.example.lebigo

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextHaut: EditText
    private lateinit var editTextBas: EditText
    private lateinit var buttonHaut: ImageButton
    private lateinit var buttonBas: ImageButton

    private val data = DataForBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextHaut = findViewById(R.id.editTextHaut)
        editTextBas = findViewById(R.id.editTextBas)

        buttonHaut = findViewById(R.id.buttonHaut)
        buttonBas = findViewById(R.id.buttonBas)


        buttonBas.setOnClickListener {

            val euro = editTextHaut.text.toString().toDoubleOrNull()

            if (euro != null) {
                data.resultatBas = euro * 1.13
                editTextBas.setText(data.resultatBasFormatted)
            }
        }

        buttonHaut.setOnClickListener {

            val dollar = editTextBas.text.toString().toDoubleOrNull()

            if (dollar != null) {
                data.resultatHaut = dollar / 1.13
                editTextHaut.setText(data.resultatHautFormatted)
            }
        }
    }
}