package tipoProduto

import produto.Produto

class Refri(
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