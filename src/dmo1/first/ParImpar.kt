package dmo1.first

fun main() {

    println("Digite o numero: ")
    val num = readLine()?.toIntOrNull() ?: 0
    if(num != null) {
        val ehPar = if(num % 2 == 0) {
        "Par"
        } else {
        "Impar"
        }
        println("O numero é $ehPar!")
    } else println("O valor não pode ser nulo")
}