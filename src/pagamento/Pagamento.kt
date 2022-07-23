package pagamento

import carrinho.Carrinho

class Pagamento (
    private var precoTotalCarrinho: Double = 0.0
        ){

    fun trocoDinheiro(){
        println("Qual valor você possui dinheiro?")
        var valor = readln().toDouble()
        if (valor < precoTotalCarrinho){
            println("valor insuficiente")
        }else{
            var desconto = valor - precoTotalCarrinho
            println("Troco: $desconto")
            println("Compra finalizada com sucesso! Boa refeição")
        }
    }

    fun finalizacao(){
        println("Qual forma pagamento?\n" +
                "[1] -> Cartão Debito\n" +
                "[2] -> Cartão Credito\n" +
                "[3] -> Cartão Refeição\n" +
                "[4] -> Dinheiro")
        var opcaoFormaPagamento = readln().toInt()

        when{
            opcaoFormaPagamento == 1 ->{
                println("Compra finalizada com sucesso! Boa refeição")
            }
            opcaoFormaPagamento == 2 ->{
                println("Compra finalizada com sucesso! Boa refeição")
            }
            opcaoFormaPagamento == 3 ->{
                println("Compra finalizada com sucesso! Boa refeição")
            }
            opcaoFormaPagamento == 4 ->{
                trocoDinheiro()
            }
        }
    }
}