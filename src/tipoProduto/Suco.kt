package tipoProduto

import produto.Produto

class Suco(
nome:String,
preco:Double,
quantidade:Int,
precoTotal: Double
) : Produto(
nome,
preco,
quantidade,
precoTotal
){
}