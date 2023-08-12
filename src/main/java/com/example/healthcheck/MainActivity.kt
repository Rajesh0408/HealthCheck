package com.example.healthcheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            val weight = findViewById<EditText>(R.id.etWeight).text.toString()
            val height = findViewById<EditText>(R.id.etHeight).text.toString()
            val tvAnswer = findViewById<TextView>(R.id.tvAnswer)
            val tvAns = findViewById<TextView>(R.id.tvAns)
            val tvlast= findViewById<TextView>(R.id.tvlast)
            var answer=0.0f
            var color=0
            if(emptyCheck(weight,height)){
                answer = weight.toFloat()/((height.toFloat()/100)*(height.toFloat()/100))
                tvAnswer.text=String.format("%.f2f",answer)
                when{
                    answer<18.50 ->{
                        tvAns.text="UnderWeight"
                        color=R.color.Underweight
                    }
                    answer>29.99 ->{
                        tvAns.text="Obese"
                        color=R.color.Obese
                    }
                    answer in 18.50..24.99 ->{
                        tvAns.text="Healthy"
                        color=R.color.Normal
                    }
                    answer in 25.00..29.99 ->{
                        tvAns.text="OverWeight"
                        color=R.color.Overweight
                    }

                }

                tvAns.setTextColor(ContextCompat.getColor(this,color))
                tvlast.text="Normal Range is 18.50 - 24.99"
            }



        }



    }
    private fun emptyCheck(weight: String,height:String): Boolean{
        return when {
            weight.isEmpty() ->{
                Toast.makeText(this,"Please enter the weight",Toast.LENGTH_LONG).show()
                false
            }

            height.isEmpty() ->{
                Toast.makeText(this,"Please enter the height",Toast.LENGTH_LONG).show()
                false
            }

            else ->{
                true
            }
        }

    }
}