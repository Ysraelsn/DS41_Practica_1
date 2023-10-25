package com.uth.disapp.jisn.convertidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var temperatura: String = ""
    private var selectedOption: Int = 0
    private var result: Double = 0.0
    private lateinit var total : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultado = findViewById<TextView>(R.id.Resultado)
        val opcion = findViewById<Spinner>(R.id.Selector)
        val temp = findViewById<EditText>(R.id.Input)
        val convert = findViewById<Button>(R.id.btnConvertir)
        total=findViewById(R.id.Resultado)

        convert.setOnClickListener{

            temperatura = temp.text.toString()

            conversion(selectedOption)
        }

        if(opcion != null){
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.convert_options)
            )
            opcion.adapter = adapter

            opcion.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    selectedOption = position
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        }
    }

    private fun conversion(option: Int) {
        when(option){
            0->{ //C A F F=Cx1.8+32
                result = (temperatura.toDouble()*9/5)+32
                total.text = String.format("%.2f", result)

            }
            1->{ //C a K
                result = (temperatura.toDouble()+273.15)
                total.text = String.format("%.2f", result)

            }
            2->{//F a C
                result = (temperatura.toDouble()-32)/1.8
                total.text = String.format("%.2f", result)

            }
            3->{// F a K
                result = ((temperatura.toDouble()-32)*5/9)+273.15
                total.text = String.format("%.2f", result)

            }
            4->{// K a C
                result = (temperatura.toDouble()-273.15)
                total.text = String.format("%.2f", result)

            }
            5->{// K a F
                result = ((temperatura.toDouble()-273.15)*9/5)+32
                total.text = String.format("%.2f", result)

            }
        }
    }
}