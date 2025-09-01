package dmo1.second

fun main() {
    // --- List ---
    // Coleção ordenada, permite elementos duplicados
    // Pode ser imutável (listOf) ou mutável (mutableListOf)

    val nomes = listOf("Ana", "Bruno", "Carlos", "Ana") // Imutável
    println("Nome na posição 0: ${nomes[0]}")
    println("Tamanho da lista nomes: ${nomes.size}")

    val numeros = mutableListOf(1, 2, 3) // Mutável
    numeros.add(4)
    numeros.remove(2)
    println("Números atualizados: $numeros")

    // Métodos úteis da List:
    // size, add (mutável), get ([], get(i)), first(), last(), contains(x),
    // indexOf(x), lastIndexOf(x), isEmpty(), isNotEmpty(), subList(a, b),
    // filter { }, map { }, sorted(), sortedDescending(), toSet(), forEach { }

    // --- Set ---
    // Coleção de elementos únicos (sem duplicados)
    // Não garante ordem (exceto linkedSetOf)
    // Pode ser imutável (setOf) ou mutável (mutableSetOf)

    val conjunto = setOf("maçã", "banana", "maçã", "laranja")
    println("Conjunto: $conjunto") // "maçã" aparece uma vez

    val numerosSet = mutableSetOf(10, 20, 30)
    numerosSet.add(20) // não adiciona duplicado
    numerosSet.add(40)
    println("Set mutável: $numerosSet")

    // Métodos úteis do Set:
    // size, contains(x), isEmpty(), isNotEmpty(), add(x) (mutável),
    // remove(x) (mutável), union(...), intersect(...), subtract(...),
    // first(), last(), forEach { }

    // --- Map ---
    // Coleção de pares chave→valor
    // Chaves únicas, valores podem se repetir
    // Pode ser imutável (mapOf) ou mutável (mutableMapOf)

    val capitais = mapOf("SP" to "São Paulo", "RJ" to "Rio de Janeiro")
    println("Capital de SP: ${capitais["SP"]}")

    val estoque = mutableMapOf("arroz" to 10, "feijão" to 5)
    estoque["macarrão"] = 7
    estoque["arroz"] = 15
    println("Estoque atualizado: $estoque")

    // Métodos úteis do Map:
    // size, keys, values, containsKey(k), containsValue(v), get(k)/[k],
    // getOrDefault(k,v), put(k,v) (mutável), remove(k) (mutável), forEach { (k,v) -> }

    // --- Array ---
    // Tamanho fixo, mas elementos podem ser alterados
    val arr = arrayOf(10, 20, 30)
    arr[1] = 99
    println("Array modificado: ${arr.joinToString()}")

    // --- Resumo comparativo ---
    // List: ordenada, permite duplicados
    // Set: elementos únicos, ordem não garantida
    // Map: pares chave→valor, chaves únicas
    // Array: tamanho fixo, permite alteração dos elementos

    /*
     * Exercícios Fixação sugeridos:
     * 1) Ler 5 números, guardar em List, filtrar pares, imprimir ou informar se não há pares.
     * 2) Ler frase, dividir em palavras, contar palavras únicas usando Set, mostrar resultado.
     */
}
