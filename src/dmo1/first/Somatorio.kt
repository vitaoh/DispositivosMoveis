package dmo1.first

fun main() {

    println("Digite a quantidade de numeros que deseja somar: ")
    val quantNum = readLine()?.toIntOrNull() ?: 0
    var total = 0.0

    for (i in 1..quantNum) {
        println("Numero $i: ")
        val num = readLine()?.toDoubleOrNull() ?: 0.0
        total += num
    }
    println("Total: $total")
}