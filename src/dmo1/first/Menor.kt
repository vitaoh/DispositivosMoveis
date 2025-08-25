package dmo1.first

fun main() {

    println("Digite 3 numeros: ")
    var menor: Double? = null
    for (i in 1..3) {
        val num = readLine()?.toDoubleOrNull()
        if(num != null) {
            if(menor == null || menor > num) {
                menor = num
            }
        } else {
            println("Número inválido. Por favor, insira um número válido.")
        }
    }
    if(menor != null) {
        println("Menor numero: $menor")
    } else {
        println("Numeros inválidos!")
    }
}