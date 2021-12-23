package com.example.guerradecartas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val j= Jugadores()
        j.play()
    }
}

val palos = mapOf('e' to "Espada", 'b' to "Basto", 'o' to "Oro", 'c' to "Copa")

data class Carta(val num: Int, val palo: Char){
    override fun toString() = "$num de ${palos[palo]}"
}
//shuffle
class Jugadores() {
    val nroJugadores= 2//(1..4).random()

    fun play(){
        var mazo: MutableList<Carta> = mutableListOf()
        var jugadores: MutableList<MutableList<Carta>> = mutableListOf()
        val cantidades=mazo.size/nroJugadores
        var carta: Int=0
        var jugador=0

        for (palo in "eboc"){
            for (num in 1..12){
                mazo.add(Carta(num,palo))
            }
        }

        repeat(nroJugadores){
            jugadores.add(mutableListOf<Carta>())
            repeat(cantidades){
                carta= (0 until mazo.size).random()
                jugadores[jugador].add(mazo[carta])
                mazo.removeAt(carta)
            }
            jugador++
        }
    }
}


