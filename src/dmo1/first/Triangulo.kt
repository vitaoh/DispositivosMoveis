package dmo1.first

fun main() {

    println("Digite o tamanho do triângulo: ")
    val tam = readLine()?.toIntOrNull() ?: 0

    for (i in 1..tam) {
        println("#".repeat(i))
    }
}
