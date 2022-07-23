package carrinho

import produto.Produto
import tipoProduto.Refri
import tipoProduto.Suco
import tipoProduto.Xburguer
import tipoProduto.Xsalada
import pagamento.Pagamento

class Carrinho {

    var codigo = 50

    var precoTotalCarrinho = 0.0

    private val listaItens = mutableMapOf<Int, Produto>()


     private fun ValorParcial(qntd: Int, valorUnitario: Double): Double {
        val valorParcial = qntd * valorUnitario
        return valorParcial
    }


   private fun pedirQuantidade() : Int {
       return try {
           println("Digite quantidade:")
           readln().toInt()
       }catch (ex : Exception){
           ex.toString()
           println("Não aceito letras apena numeros")
           pedirQuantidade()
       }
   }

    fun inserirCarrinho(item: Produto) : Int{
        codigo += 1
        listaItens[codigo] = item

        return codigo

    }

    fun quantidadeXBurguer(){
        val qnt = pedirQuantidade()
        val valorParcial = ValorParcial(qnt,10.0)
        val item = Xburguer(
            nome="x -burguer",
            preco = 10.00,
            quantidade = qnt,
            precoTotal = valorParcial
        )
        inserirCarrinho(item)
        valorTotal()
    }

    fun quantidadeXSalada(){
        val qnt = pedirQuantidade()
        val valorParcial= ValorParcial(qnt, 12.0)
        val item = Xsalada(
            nome="X-Salada",
            preco = 12.00,
            quantidade = qnt,
            precoTotal = valorParcial
        )
        inserirCarrinho(item)
        valorTotal()
    }

    fun quantidadeRefri(){
        val qnt = pedirQuantidade()
        val valorParcial= ValorParcial(qnt, 8.0)
        val item = Refri(
            nome="Refri",
            preco = 8.00,
            quantidade = qnt,
            precoTotal = valorParcial
        )
        inserirCarrinho(item)
        valorTotal()
    }

    fun quantidadeSuco(){
        val qnt = pedirQuantidade()
        val valorParcial= ValorParcial(qnt, 6.00)
        val item = Suco(
            nome="Suco",
            preco = 6.00,
            quantidade = qnt,
            precoTotal = valorParcial

        )
        inserirCarrinho(item)
        valorTotal()
    }

    fun exibirCarrinho(){
        listaItens.forEach { codigo, produto ->
            println("$codigo - ${produto.nome} | Quantidade: ${produto.quantidade} | Preço de Produto: ${produto.precoTotal}")
        }
        println("Total carrinho: ${precoTotalCarrinho}")

    }

    private fun valorTotal(){
        var precoTotal = 0.0
        listaItens.forEach { codigo, produto ->
            precoTotal += produto.precoTotal

        }
        precoTotalCarrinho = precoTotal
    }

    fun pagamento(){
        var pagamento = Pagamento(precoTotalCarrinho)
        pagamento.finalizacao()
    }

    fun verificarCodigo(): Int{
        println("Qual o código? ")
        val buscarCodigo = readln().toInt()
       return buscarCodigo
    }

    fun removerItem() {
        try {
            var codigoDigitado = verificarCodigo()

            if (codigoDigitado in listaItens) {
                listaItens.remove(codigoDigitado)
                valorTotal()
                println("item removido")
            } else {
                println("codigo invalido!")
                removerItem()
            }
        }catch (ex:Exception) {
            ex.toString()
            println("Porfavor digite apena numero não a letras")
            removerItem()
        }
    }

    fun editarItem() {
        try {
            var codigoDigitado = verificarCodigo()
            if (codigoDigitado in listaItens) {
                var produto = listaItens[codigoDigitado]
                if (produto != null) {
                    produto.quantidade = editarQuantidade()
                    produto.precoTotal = produto.quantidade * produto.preco
                    valorTotal()
                    println("Quantidade editada")
                }
            } else {
                println("codigo invalido!")
                editarItem()
            }
    }catch(ex:Exception){
        ex.toString()
        println("Porfavor digite apena numero não a letras")
        editarItem()
    }
    }

    fun editarQuantidade(): Int{
        println("Escrever novo quantidade")
        var novaQuantidade = readln().toInt()
        var somaNovoQuantidade =  novaQuantidade
        return somaNovoQuantidade

    }

}