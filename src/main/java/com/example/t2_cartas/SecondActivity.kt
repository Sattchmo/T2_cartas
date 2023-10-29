package com.example.t2_cartas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.snackbar.Snackbar

private lateinit var botonArriba : AppCompatImageButton
private lateinit var botonAbajo : AppCompatImageButton
private lateinit var carta : AppCompatImageView
private lateinit var contador : AppCompatTextView
var numCorriente : Int = 0;
var numSiguiente : Int = 0;
var arrCartas = arrayOf(R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,R.drawable.c11,R.drawable.c12,R.drawable.c13)
/*queria declarar la linea de arriba como "arrayOf(R.drawable.cartas)" el selector que hice para esto, pero me crasheaba continuamente la aplicacion*/
var puntos : Int = 0;

class SecondActivity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //val info = intent.extras
        instancias()
        //val root = findViewById<View>(R.id.linear_general)
        //Snackbar.make(root,"${R.string.texto_bienvenido} ${info!!.getString("textoNombre")}",Snackbar.LENGTH_INDEFINITE).setAction(R.string.texto_empezar){
            acciones()
        //}.show()
        /*igual aqui, este snackbar hace que la aplicacion crashee, por alguna razon, sin importar si esta o no en otro metodo y luego ese metodo es llamado por el OnStart*/
    }

    private fun instancias() {
        botonArriba = findViewById(R.id.boton_arriba)
        botonAbajo = findViewById(R.id.boton_abajo)
        carta = findViewById(R.id.carta_display)
        contador = findViewById(R.id.contador_puntos)
    }

    private fun acciones() {
        numCorriente = (0..12).random()
        numSiguiente = (0..12).random()
        carta.setImageResource(arrCartas[numCorriente])
        botonArriba.setOnClickListener(this)
        botonAbajo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.boton_arriba->{
                if(numSiguiente>= numCorriente){
                    puntos += numCorriente +1
                    contador.setText(puntos.toString())
                    numCorriente = numSiguiente
                    numSiguiente = (0..12).random()
                    carta.setImageResource(arrCartas[numCorriente])
                }else{
                    Snackbar.make(v,"Haz perdido. puntos: ${contador.text}",Snackbar.LENGTH_INDEFINITE).setAction(R.string.texto_salir){
                        finish() /*por alguna razon, el string que he hecho para cuando el jugador pierde se muestra como "2131689641" si lo llamo desde strings.xml*/
                    }.show()
                }
            }
            R.id.boton_abajo->{
                if(numSiguiente<= numCorriente){
                    puntos += numCorriente +1
                    contador.setText(puntos.toString())
                    numCorriente = numSiguiente
                    numSiguiente = (0..12).random()
                    carta.setImageResource(arrCartas[numCorriente])
                }else{
                    Snackbar.make(v,"Haz perdido. puntos: ${contador.text}",Snackbar.LENGTH_INDEFINITE).setAction(R.string.texto_salir){
                        finish()
                    }.show()
                }
            }
        }
    }
}