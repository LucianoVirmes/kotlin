package br.edu.unoesc

import java.util.function.DoublePredicate

data class Superficie( val altura: Double, val largura: Double) {
    //var varia
    //val é constante

    fun getArea():Double {
        return altura*largura;
    }


}