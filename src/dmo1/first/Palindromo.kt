package dmo1.first

fun main() {

    println("Digite uma palavra ou frase: ")
    val entrada = (readln() ?: "Padrão").uppercase()
    println(entrada)
    if(entrada == entrada.reversed()) println("É um Palindromo!") else println("Não é um Palindromo!")
}