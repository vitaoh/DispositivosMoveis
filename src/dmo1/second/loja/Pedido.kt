package dmo1.second.loja

class Pedido(val cliente: Cliente) {
    private val itens = mutableListOf<Produto>()
    var cupom: Cupom? = null

    fun adicionarProduto(produto: Produto) {
        itens.add(produto)
        println("${produto.nome} adicionado ao carrinho.")
    }

    fun calcularSubtotal(): Double {
        return itens.sumOf { it.preco }
    }

    fun calcularFrete(): Double {
        val pesoTotal = itens.filter { it.ehFisico }.sumOf { it.peso }
        return pesoTotal * 5.0
    }

    fun calcularDesconto(): Double {
        val subtotal = calcularSubtotal()
        return cupom?.let { subtotal * it.descontoPercentual / 100.0 } ?: 0.0
    }

    fun calcularTotal(): Double {
        return calcularSubtotal() - calcularDesconto() + calcularFrete()
    }

    fun resumo(): String {
        val builder = StringBuilder()
        builder.append("Cliente: ${cliente.nome} - Email: ${cliente.email}\n")
        builder.append("Itens adquiridos:\n")
        itens.forEach {
            builder.append("- ${it.nome}: R$%.2f\n".format(it.preco))
        }
        val subtotal = calcularSubtotal()
        val desconto = calcularDesconto()
        val frete = calcularFrete()
        val total = calcularTotal()

        builder.append("Subtotal: R$%.2f\n".format(subtotal))
        if (desconto > 0) {
            builder.append("Desconto (${cupom?.codigo}): -R$%.2f\n".format(desconto))
        }
        if (frete > 0) {
            builder.append("Frete: R$%.2f\n".format(frete))
        }
        builder.append("Total: R$%.2f\n".format(total))

        return builder.toString()
    }
}