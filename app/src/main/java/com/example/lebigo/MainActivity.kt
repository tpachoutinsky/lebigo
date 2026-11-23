package com.example.lebigo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import com.example.lebigo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val data = DataForBinding()
    private lateinit var dataForBindingViewModel: DataForBindingViewModel
    private var tauxActuel = TauxConversion.EURO_DOLLAR

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataForBindingViewModel = ViewModelProvider(this).get(DataForBindingViewModel::class.java)
        binding.infoIhm = dataForBindingViewModel
        binding.lifecycleOwner = this@MainActivity

        binding.buttoneurodollar.setOnClickListener {
            tauxActuel = TauxConversion.EURO_DOLLAR

            binding.textViewHaut.text = getString(R.string.euro)
            binding.textViewBas.text = getString(R.string.dollar)

        }
        binding.buttoneuroyen.setOnClickListener {
            tauxActuel = TauxConversion.EURO_YEN

            binding.textViewHaut.text = getString(R.string.euro)
            binding.textViewBas.text = getString(R.string.yen)
        }

        binding.buttondollaryen.setOnClickListener {
            tauxActuel = TauxConversion.DOLLAR_YEN

            binding.textViewHaut.text = getString(R.string.dollar)
            binding.textViewBas.text = getString(R.string.yen)
        }

        binding.buttonBas.setOnClickListener {

            val valeur = binding.editTextHaut.text.toString().toDoubleOrNull()

            if (valeur != null) {
                data.resultatBas = valeur * tauxActuel
                binding.editTextBas.setText(data.resultatBasFormatted)
            }
        }

        binding.buttonHaut.setOnClickListener {

            val valeur = binding.editTextBas.text.toString().toDoubleOrNull()

            if (valeur != null) {
                data.resultatHaut = valeur / tauxActuel
                binding.editTextHaut.setText(data.resultatHautFormatted)
            }
        }

    }

}