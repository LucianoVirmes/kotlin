package br.edu.unoesc

import java.sql.Date
import java.time.LocalDate


fun main(args: Array<String>){
    val csv = lerArquivo("cancelamentos.csv").drop(1);
    val classificacaoCliente = separarDados(csv, 3).groupBy { it };
    val quantidadeCanceladoPorMes = separarDados(csv, 6).groupBy { LocalDate.parse(it.replace("\"", "")).month };
    val quantidadeCanceladoPorAno = separarDados(csv,  6).groupBy { LocalDate.parse(it.replace("\"", "")).year };
    val cancelamentosPorUsuarioResponsavel = separarDados(csv, 1).groupBy { it };

    println("Número de cancelamentos por classificação do cliente: ");
    classificacaoCliente.toList().sortedByDescending { (key, value) -> value.size}.toMap().forEach {
        println("${it.key}:  ${it.value.size}");
    }

    println("Média de tempo de vida no sistema: "+ calcularMediaEntreDatas(csv, 5,6));

    println("Quantidade de cancelamento por mês: ");
    quantidadeCanceladoPorMes.toList().sortedBy { (key, value) -> value.size }.toMap().forEach {
        println("${it.key}:  ${it.value.size}");
    }

    println("Quantidade de cancelamento por ano: ");
    quantidadeCanceladoPorAno.toList().sortedBy { (key, value) -> value.size }.toMap().forEach {
        println("${it.key}:  ${it.value.size}");
    }

    println("Quantidades de cancelamento por usuário responsável: ")
    cancelamentosPorUsuarioResponsavel.toList().sortedByDescending { (key, value) -> value.size }.toMap().forEach {
       println("${it.key}:  ${it.value.size}")
    }

}