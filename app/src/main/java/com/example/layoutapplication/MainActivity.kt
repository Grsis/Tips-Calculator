package com.example.layoutapplication

import android.content.Intent
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

        binding.btnDone.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val numbPeopleTemp = binding.tieNumPeople.text
            val percentageTemp = binding.tiePercentage.text


            if (totalTableTemp?.isEmpty() == true ||
                numbPeopleTemp?.isEmpty() == true  ||
                percentageTemp?.isEmpty() == true

            ) {
                Snackbar
                    .make(binding.tieTotal, "Please complete all fields", Snackbar.LENGTH_LONG)
                    .show()
            } else {

                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = numbPeopleTemp.toString().toInt()
                val percentage:Int =percentageTemp.toString().toInt()

                val totaltTemp = totalTable / nPeople
                val tips = totaltTemp * percentage/ 100
                val totalWithTips = totaltTemp + tips
                val intent = Intent(this, SummaryActivity:: class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("numPeople", nPeople)
                    putExtra("percentage", percentage )
                    putExtra("totalAmount", totalWithTips)
                }
                clean()
                startActivity(intent)
            }


        }

        binding.btnClean.setOnClickListener {
        clean()

        }
    }
    private fun clean(){
        binding.tieTotal.setText("")
        binding.tiePercentage.setText("")
        binding.tieNumPeople.setText("")

    }

}