package dmo1.first

import kotlin.random.Random

fun main() {

    val x = (1..8).random()
    val y = (1..8).random()
    val tipoCasa = if ((x + y) % 2 == 0) "Casa PRETA" else "Casa BRANCA"
    println("Posição: ($x, $y) - $tipoCasa")
}