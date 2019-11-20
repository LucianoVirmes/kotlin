package br.edu.unoesc.util

import br.edu.unoesc.model.Parcela
import java.time.LocalDate
import kotlin.collections.ArrayList

fun gerarParcelas(numeroParcelas: Long, valorTotal: Double, intervaloDias: Long):List<Parcela> {


    val valorParcela: Double = valorTotal/numeroParcelas;
    var parcelas: List<Parcela> = ArrayList();


    for(i in 0 until numeroParcelas){

        var novaData = if (parcelas.isEmpty()) {
            LocalDate.now().plusMonths(1)
        } else {
            parcelas.last().data.plusDays(intervaloDias);
        }

        parcelas += Parcela(data = novaData, numero = i, valor = valorParcela);

    }

    return parcelas;
}