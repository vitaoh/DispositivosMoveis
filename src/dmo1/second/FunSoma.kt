package dmo1.second

fun soma(numero1: Int = 0, numero2: Int = 0): Int {
    return numero1 + numero2
}
fun main(){
    println(soma(1, 2))
    println(soma())
    println(soma(numero1 = 3, numero2 = 5))
    println(soma(numero2 = 10, numero1 = 5))
}