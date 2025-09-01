package dmo1.second.loja

class Cliente(val nome: String, val email: String)

open class Produto(val nome: String, val preco: Double, val peso: Double, val ehFisico: Boolean) {
    open fun entrega(): String {
        return "Entrega padrão"
    }
}

class LivroFisico(nome: String, preco: Double, peso: Double): Produto(nome, preco, peso, true)

class LivroDigital(nome: String, preco: Double): Produto(nome, preco, 0.0, false) {
    override fun entrega() = "Enviado por e-mail"
}

class Console(nome: String, preco: Double, peso: Double): Produto(nome, preco, peso, true)

class FilmeDigital(nome: String, preco: Double): Produto(nome, preco, 0.0, false) {
    override fun entrega() = "Acessível via player online da loja"
}

class JogoTabuleiro(nome: String, preco: Double, peso: Double): Produto(nome, preco, peso, true)

class JogoDigitalMidiaFisica(nome: String, preco: Double, peso: Double): Produto(nome, preco, peso, true)

class JogoDigitalDownload(nome: String, preco: Double): Produto(nome, preco, 0.0, false) {
    override fun entrega() = "Enviado por e-mail"
}

class Cupom(val codigo: String, val descontoPercentual: Double)

fun main() {

    println("=== Bem-Vindo à LOJA Virtual ===")
    print("Digite seu nome: ")
    val nome = readLine() ?: ""
    print("Digite seu email: ")
    val email = readLine() ?: ""
    val cliente = Cliente(nome, email)
    val pedido = Pedido(cliente)
    var opcao: Int

    do {
        println("\n=== Menu ===")
        println("1 | Livro Físico")
        println("2 | Livro Digital")
        println("3 | Console")
        println("4 | Filme Digital")
        println("5 | Jogo Tabuleiro")
        println("6 | Jogo Digital em Mídia Física")
        println("7 | Jogo Digital Download")
        println("8 | Aplicar Cupom")
        println("9 | Finalizar pedido e sair")
        print("Escolha uma opção: ")

        val catalogo = mapOf(
            1 to LivroFisico("Livro Kotlin", 120.0, 1.0),
            2 to LivroDigital("Livro Kotlin Digital", 80.0),
            3 to Console("Console X", 2000.0, 3.5),
            4 to FilmeDigital("Filme A", 25.0),
            5 to JogoTabuleiro("Jogo de Tabuleiro", 150.0, 2.0),
            6 to JogoDigitalMidiaFisica("Jogo Digital em Mídia Física", 250.0, 0.7),
            7 to JogoDigitalDownload("Jogo Digital Download", 100.0)
        )

        opcao = readLine()?.toIntOrNull() ?: 0

        when (opcao) {
            in 1..7 -> {
                val produto = catalogo[opcao]
                if (produto != null) {
                    pedido.adicionarProduto(produto)
                } else {
                    println("Produto inválido")
                }
            }
            8 -> {
                print("Digite o código do cupom: ")
                val codigoCupom = readLine()?.uppercase() ?: ""
                // Exemplo estático de cupom válido
                if (codigoCupom == "PROMO10") {
                    pedido.cupom = Cupom(codigoCupom, 10.0)
                    println("Cupom aplicado com sucesso: 10% de desconto")
                } else {
                    println("Cupom inválido")
                }
            }
            9 -> {
                println("\nResumo do pedido:")
                println(pedido.resumo())
                println("Obrigado pela compra!")
            }
            else -> println("Opção inválida, tente novamente.")
        }
    } while (opcao != 9)
}