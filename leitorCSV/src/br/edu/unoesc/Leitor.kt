package br.edu.unoesc

import java.io.BufferedReader
import java.io.FileReader
import java.sql.Date
import java.time.temporal.ChronoUnit


fun lerArquivo(nomeArquivo: String): List<String>  {
   return BufferedReader(FileReader(nomeArquivo)).readLines();
}

fun separarDados(dadosDoArquivo: List<String>, coluna: Int): List<String> {
    var dados: List<String> = ArrayList()
    for (linha in dadosDoArquivo){
        dados+=linha.split(',')[coluna];
    }
    return dados;
}
fun calcularMediaEntreDatas(dadosDoArquivo: List<String>, primeiraColuna: Int, segundaColuna: Int): Double{
    var dados: List<Int> = ArrayList();

    for (linha in dadosDoArquivo){
        val dataEntrada = Date.valueOf(linha.split(',')[primeiraColuna].replace("\"", "")).toLocalDate();
        val dataCancalamento = Date.valueOf(linha.split(',')[segundaColuna].replace("\"", "")).toLocalDate();
       dados+= dataEntrada.until(dataCancalamento, ChronoUnit.DAYS).toInt();
    }
    return dados.average()
}
