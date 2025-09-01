package dmo1.second.`fun`

fun main() {
    print("Digite o nome do aluno: ")
    val nome = readLine() ?: "Aluno"
    print("Quantas notas? ")
    val qtdNotas = readLine()?.toIntOrNull() ?: 0
    var notas = DoubleArray(qtdNotas)
    for (i in 0 until qtdNotas) {
        print("Nota ${i + 1}: ")
        notas[i] = readLine()?.toDoubleOrNull() ?: 0.0
    }
    val media = calcularMedia(*notas)
    val situacao = conceito(media)
    mostrarResultado(nome, media, situacao)
}
fun String.primeiraMaiuscula(): String {
    return when {
        this.isEmpty() -> this
        else -> this[0].uppercase() + this.substring(1).lowercase()
    }
}

fun calcularMedia(vararg notas: Double): Double {
    if (notas.isEmpty()) return 0.0
    else return notas.sum() / notas.size
}
fun conceito(media: Double): String {
    return when {
        media >= 7.0 -> "Aprovado"
        media >= 5.0 -> "Recuperação"
        else -> "Reprovado"
    }
}
fun mostrarResultado(nome: String, media: Double, situacao: String) {
    println("Aluno: ${nome.primeiraMaiuscula()}")
    println("Média: %.2f".format(media))
    println("Situação: $situacao")
}