package com.example.layoutapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.layoutapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    //  Valor total da conta
    // Numero de pessoas
    // Percentagem da gorjeta
    // 10% , 15% ou 20%
    // Calcular
    // Limpar

    // Recuperar as views do layout
    // ViewBinding

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0
        binding.rbOptionOne.setOnCheckedChangeListener { _, isChecked ->
            println("Roque1 Option one:$isChecked")
            if (isChecked) {
                percentage = 10
            }
        }

        binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
            println("Roque1 Option two:$isChecked")
            if (isChecked) {
                percentage = 15
            }
        }

        binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
            println("Roque1 Option three:$isChecked")
            if (isChecked) {
                percentage = 20
            }
        }


        binding.btnClean.setOnClickListener {
            println("Roque1 " + binding.tieTotal.text)
            println("Roque1 " + binding.tieNumPeople.text)

        }
        binding.btnDone.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val nPeopleTemp = binding.tieNumPeople.text

            if (totalTableTemp?.isEmpty() == true ||
                nPeopleTemp?.isEmpty() == true
            ) {
                Snackbar.make(binding.tieTotal, "Please complete all fields", Snackbar.LENGTH_LONG)
                    .show()
            } else {

                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = nPeopleTemp.toString().toInt()

                val totaltTemp = totalTable / nPeople
                val tips = totaltTemp * percentage / 100
                val totalWithTips = totaltTemp + tips
                binding.tvResult.text = "Total with tips: $totalWithTips"
            }


        }

        binding.btnClean.setOnClickListener {
            binding.tvResult.text = ""
            binding.tieTotal.setText("")
            binding.tieNumPeople.setText("")
            binding.rbOptionThree.isChecked = false
            binding.rbOptionOne.isChecked = false
            binding.rbOptionTwo.isChecked = false
        }
    }

}