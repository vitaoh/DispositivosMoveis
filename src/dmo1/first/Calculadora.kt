package dmo1.first

fun main() {

    println("Digite [NUMERO] [OPERACAO] [NUMERO], nessa ordem: ")

    val num1 = readLine()?.toDoubleOrNull() ?: Double.NaN
    val ope = readLine()
    val num2 = readLine()?.toDoubleOrNull() ?: Double.NaN

    if (num1 != null && num2 != null && ope != null) {
        when (ope) {
            "+" -> println("Resultado: ${num1 + num2}")
            "-" -> println("Resultado: ${num1 - num2}")
            "*" -> println("Resultado: ${num1 * num2}")
            "/" -> {
                if (num2 != 0.0) {
                    println("Resultado: ${num1 / num2}")
                } else {
                    println("Operação inválida! \nNão é possível dividir por zero!")
                }
            }
            else -> println("Operação inválida!")
        }
    } else {
        println("Entrada inválida!")
    }
}
