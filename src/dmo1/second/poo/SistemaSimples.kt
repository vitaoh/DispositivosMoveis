package dmo1.second.poo

// SistemaSimples.kt - Sistema de Pedidos Simplificado

// ===== PRODUTO BASE =====
abstract class Produto(val nome: String, val preco: Double) {
    abstract val ehDigital: Boolean
    abstract fun calcularFrete(): Double
}

// ===== INTERFACE =====
interface Entregavel {
    fun podeEnviarPorEmail(): Boolean
}

// ===== PRODUTOS CONCRETOS =====
class Livro(nome: String, preco: Double, val peso: Double, override val ehDigital: Boolean) : Produto(nome, preco), Entregavel {
    override fun calcularFrete() = if (ehDigital) 0.0 else peso * 5.0
    override fun podeEnviarPorEmail() = ehDigital
}

class Jogo(nome: String, preco: Double, override val ehDigital: Boolean, val peso: Double = 0.0) : Produto(nome, preco), Entregavel {
    override fun calcularFrete() = if (ehDigital) 0.0 else peso * 5.0
    override fun podeEnviarPorEmail() = ehDigital
}

class Console(nome: String, preco: Double, val peso: Double) : Produto(nome, preco) {
    override val ehDigital = false
    override fun calcularFrete() = peso * 5.0
}

// ===== AUXILIARES =====
data class Cliente(val nome: String, val email: String)
data class Cupom(val codigo: String, val desconto: Double)

// ===== PEDIDO =====
class Pedido(val cliente: Cliente) {
    private val itens = mutableListOf<Produto>()
    private var cupom: Cupom? = null

    fun adicionar(produto: Produto) = itens.add(produto)
    fun aplicarCupom(cupom: Cupom) { this.cupom = cupom }

    private fun subtotal() = itens.sumOf { it.preco }
    private fun frete() = itens.sumOf { it.calcularFrete() }
    private fun desconto() = cupom?.let { subtotal() * (it.desconto / 100) } ?: 0.0

    fun total() = subtotal() + frete() - desconto()

    fun resumo() {
        println("=".repeat(40))
        println("PEDIDO - ${cliente.nome}")
        println("=".repeat(40))

        itens.forEachIndexed { i, produto ->
            println("${i+1}. ${produto.nome} - R$ ${produto.preco}")
        }

        println()
        println("Subtotal: R$ %.2f".format(subtotal()))
        cupom?.let { println("Desconto (${it.codigo}): -R$ %.2f".format(desconto())) }
        if (frete() > 0) println("Frete: R$ %.2f".format(frete()))
        println("TOTAL: R$ %.2f".format(total()))

        println("Entrega:")
        itens.filterIsInstance<Entregavel>()
            .filter { it.podeEnviarPorEmail() }
            .takeIf { it.isNotEmpty() }
            ?.let { println("• Email: ${it.size} itens digitais") }

        itens.filter { !it.ehDigital }
            .takeIf { it.isNotEmpty() }
            ?.let { println("• Correios: ${it.size} itens físicos") }
    }
}

// ===== EXEMPLO =====
fun main() {
    println("Sistema de Pedidos - Loja Virtual")

    val cliente = Cliente("João Silva", "joao@email.com")
    val pedido = Pedido(cliente)

    // Adicionando produtos
    pedido.adicionar(Livro("Clean Code", 89.90, 0.5, false))
    pedido.adicionar(Livro("Kotlin Guide", 45.00, 0.0, true))
    pedido.adicionar(Console("PlayStation 5", 3999.99, 4.5))
    pedido.adicionar(Jogo("Cyberpunk", 199.90, true))
    pedido.adicionar(Jogo("FIFA 24", 299.90, false, 0.1))

    // Aplicando cupom
    pedido.aplicarCupom(Cupom("DESCONTO10", 10.0))

    // Mostrando resumo
    pedido.resumo()

    println("\n" + "=".repeat(40))
    println("SEGUNDO PEDIDO (Só digitais)")
    println("=".repeat(40))

    val cliente2 = Cliente("Maria Santos", "maria@email.com")
    val pedido2 = Pedido(cliente2)

    pedido2.adicionar(Livro("Design Patterns", 35.00, 0.0, true))
    pedido2.adicionar(Jogo("Indie Game", 29.90, true))
    pedido2.aplicarCupom(Cupom("DIGITAL15", 15.0))

    pedido2.resumo()
}
