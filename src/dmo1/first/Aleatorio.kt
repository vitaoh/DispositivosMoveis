package dmo1.first

import kotlin.random.Random

fun main() {

    val numeroSecreto = Random.nextInt(1, 101)
    var tentativas = 0
    val limite = 10
    var acertou = false

    println("========= Jogo da Adivinhação =========")
    println("Tente adivinhar o número entre 1 e 100!")
    println("Você tem $limite tentativas.")

    while (tentativas < limite && !acertou) {
        print("Tentativa ${tentativas + 1}: ")
        val palpite = readLine()?.toIntOrNull() ?: -1
        tentativas++

        when {
            palpite == numeroSecreto -> acertou = true
            palpite < numeroSecreto -> println("O número secreto é MAIOR.")
            else -> println("O número secreto é MENOR.")
        }
    }

    if (acertou)
        println("Parabéns! Você acertou em $tentativas tentativa(s)!")
    else
        println("Suas tentativas acabaram. O número era $numeroSecreto.")
}