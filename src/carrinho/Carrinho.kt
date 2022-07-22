package carrinho

import Produto
import Refri
import Suco
import Xburguer
import Xsalada
import pagamento.Pagamento

class Carrinho {

    var codigo = 50

    var precoTotalCarrinho = 0.0

    private val listaItens = mutableMapOf<Int, Produto>()


    fun ValorParcial(qntd: Int, valorUnitario: Double): Double {
        val valorParcial = qntd * valorUnitario
        return valorParcial
    }


    fun pedirQuantidade() : Int{
        println("digite quantidade")
        return readln().toIntOrNull() ?: 0
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
        val item =Xsalada(
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
            println("$codigo - ${produto.nome} | Quantidade: ${produto.quantidade} | Preco Produto: ${produto.precoTotal}")
        }
        println("Total carrinho: ${precoTotalCarrinho}")

    }

    fun valorTotal(){
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


}