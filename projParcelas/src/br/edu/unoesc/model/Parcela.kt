package br.edu.unoesc.model

import java.time.LocalDate
import java.util.*

class Parcela (val data: LocalDate, val numero: Long, val valor: Double){
    override fun toString(): String {
        return "Parcela(data=$data, numero=$numero, valor=$valor)"
    }
}