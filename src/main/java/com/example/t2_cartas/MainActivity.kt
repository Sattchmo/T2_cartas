package com.example.t2_cartas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.snackbar.Snackbar

private lateinit var botonEmpezar: AppCompatButton
lateinit var textoNombre: AppCompatEditText


class MainActivity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias();
        acciones();
    }

    private fun acciones() {
        botonEmpezar.setOnClickListener(this);
    }

    private fun instancias() {
        botonEmpezar = findViewById(R.id.boton_empezar)
        textoNombre = findViewById(R.id.texto_nombre)
    }

    override fun onClick(v: View?) {

        when(v!!.id){
            R.id.boton_empezar->{
                if(textoNombre.text?.isBlank() == true){
                    Snackbar.make(v,resources.getString(R.string.texto_sin_nombre),Snackbar.LENGTH_SHORT).show()
                }else{
                    Snackbar.make(v,"${resources.getString(R.string.texto_perfecto)} ${textoNombre.text} ${resources.getString(R.string.texto_proceder)}",Snackbar.LENGTH_INDEFINITE)
                        .setAction(resources.getString(R.string.texto_ok)){
                            val intent = Intent(applicationContext, SecondActivity::class.java)
                            startActivity(intent)
                        }.show()
                }
            }
        }

    }
}