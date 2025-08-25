package dmo1.first

fun main() {
    println("Digite o tamanho do triângulo: ")
    val tam = readLine()?.toIntOrNull() ?: 0

    for (i in 1..tam) {
        for (j in 1..tam - i) {
            print(" ")
        }
        for (k in 1..i) {
            print("#")
        }
        println()
    }
}
