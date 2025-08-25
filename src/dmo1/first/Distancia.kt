package dmo1.first

import kotlin.math.*
import kotlin.random.Random

const val TAM = 10

fun jogo() {

    val jogador1x = Random.nextInt(TAM)
    val jogador1y = Random.nextInt(TAM)
    val jogador2x = Random.nextInt(TAM)
    val jogador2y = Random.nextInt(TAM)

    if(jogador2y == jogador1y && jogador2x == jogador1x) {
        jogo()
    }

    for (i in 0 until TAM) {
        for (j in 0 until TAM) {
            if (j == jogador1x && i == jogador1y) {
                print(" X ")
            } else
            if (j == jogador2x && i == jogador2y) {
                print(" Y ")
            } else print(" . ")
        }
        println()
    }

    val distx = jogador2x - jogador1x
    val disty = jogador2y - jogador1y

    val d = sqrt(distx.toDouble().pow(2) + disty.toDouble().pow(2));

    println("\nDistância entre jogador1 e jogador2: %.2f".format(d))

    if(d <= 5) {
        println("ENTRAR NO MODO ATAQUE!")
    }
}

fun main() {
    jogo()
}
