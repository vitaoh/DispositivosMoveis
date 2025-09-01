package dmo1.second.poo

// ConceptosOOP.kt - Orientação a Objetos em Kotlin (Resumido)

// ===== 1. CLASSES BÁSICAS =====
class Pessoa(val nome: String, var idade: Int) {
    val anoNascimento get() = 2025 - idade

    init {
        require(idade >= 0) { "Idade inválida" }
    }

    fun apresentar() = println("$nome, $idade anos")
}

// ===== 2. ENCAPSULAMENTO =====
class ContaBancaria(private var saldo: Double) {
    fun depositar(valor: Double) {
        if (valor > 0) saldo += valor
    }

    fun consultarSaldo() = saldo
}

// ===== 3. HERANÇA E POLIMORFISMO =====
open class Animal(val nome: String) {
    open fun som(): String = "Som genérico"
    open fun mover() = println("$nome se movendo")
}

class Cachorro(nome: String) : Animal(nome) {
    override fun som() = "Au au!"
    override fun mover() = println("$nome correndo")
}

class Gato(nome: String) : Animal(nome) {
    override fun som() = "Miau"
}

// ===== 4. CLASSE ABSTRATA =====
abstract class Veiculo(val modelo: String) {
    abstract fun acelerar()
    fun mostrarInfo() = println("Veículo: $modelo")
}

class Carro(modelo: String) : Veiculo(modelo) {
    override fun acelerar() = println("$modelo acelerando")
}

// ===== 5. DATA CLASS =====
data class Usuario(val id: Int, val nome: String, val email: String)

// ===== 6. SEALED CLASS =====
sealed class Resultado {
    data class Sucesso(val dados: String) : Resultado()
    data class Erro(val mensagem: String) : Resultado()
    object Carregando : Resultado()
}

fun processar(resultado: Resultado) = when (resultado) {
    is Resultado.Sucesso -> "✓ ${resultado.dados}"
    is Resultado.Erro -> "✗ ${resultado.mensagem}"
    Resultado.Carregando -> "⏳ Carregando..."
}

// ===== 7. COMPANION OBJECT =====
class MinhaClasse {
    companion object {
        const val VERSAO = "1.0"
        fun criar() = MinhaClasse()
    }
}

// ===== 8. OBJECT (SINGLETON) =====
object ConfigApp {
    var tema = "claro"
    fun alterarTema(novoTema: String) { tema = novoTema }
}

// ===== EXEMPLO COMPLETO =====
fun main() {
    println("=== OOP em Kotlin ===")

    // Classes básicas
    val pessoa = Pessoa("Ana", 25)
    pessoa.apresentar()

    // Encapsulamento
    val conta = ContaBancaria(100.0)
    conta.depositar(50.0)
    println("Saldo: R$ ${conta.consultarSaldo()}")

    // Polimorfismo
    val animais = listOf(Cachorro("Rex"), Gato("Mimi"))
    animais.forEach { 
        println("${it.nome}: ${it.som()}")
        it.mover()
    }

    // Data class
    val user = Usuario(1, "João", "joao@email.com")
    val userCopy = user.copy(email = "novo@email.com")
    println("Original: $user")
    println("Cópia: $userCopy")

    // Sealed class
    listOf(
        Resultado.Sucesso("Login OK"),
        Resultado.Erro("Senha inválida"),
        Resultado.Carregando
    ).forEach { println(processar(it)) }

    // Companion object
    println("Versão: ${MinhaClasse.VERSAO}")

    // Object singleton
    ConfigApp.alterarTema("escuro")
    println("Tema atual: ${ConfigApp.tema}")
}
