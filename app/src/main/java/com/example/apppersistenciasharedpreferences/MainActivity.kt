package com.example.apppersistenciasharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences= SharedPreferences(this)

        val botonGrabar=findViewById<Button>(R.id.btnSave)

        val botonRetrieve=findViewById<Button>(R.id.btn_retrieve)

        botonGrabar.setOnClickListener {
            val hint=findViewById<TextView>(R.id.etName)
            val name=hint.text.toString()

            //grabo el real texto en el SharedPref

            sharedPreferences.save("name",name)

            Toast.makeText(this,"Data stored",Toast.LENGTH_LONG).show()
        }

        botonRetrieve.setOnClickListener {

            val textoLista=findViewById<TextView>(R.id.tvRetrieve)
            if(sharedPreferences.getValue("name")!=null){
                textoLista.setText(sharedPreferences.getValue("name"))
            }
        }




    }
}