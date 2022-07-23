package menu

import carrinho.Carrinho

class Menu {
    var opcao = 0
    var opcaoLanche = 0
    var opcaoBebida = 0
    private val carrinho = Carrinho()


    fun menu() {

        try {
            println("Oque você quer comprar:?")
            println(
                "[1] - Lanche\n" +
                        "[2] - Bebida"
            )
            opcao = readln().toInt()
        } catch (ex: Exception) {
            ex.toString()
            println("Não aceito letras apena numeros")
            menu()
        }

        when {
            opcao == 1 -> {
                menuLanche()
            }
            opcao == 2 -> {
                menuBebida()
            }
            else -> {
                println("Opção inválido Por Favor digite apena exista 1 ou 2")
                menu()
            }
        }
    }

    private fun menuLanche() {
        try {
            println("Qual lanche gostaria adicionar?:")
            println(
                "[1] -> X-burguer\n" +
                        "[2] -> X-salada"
            )
            opcaoLanche = readln().toInt()

            when {
                opcaoLanche == 1 -> {
                    println("-------- X - Burguer ---------")
                    carrinho.quantidadeXBurguer()
                    carrinho.exibirCarrinho()
                    adicionarMaisProduto()
                }
                opcaoLanche == 2 -> {
                    println("-------- X - Salada --------")
                    carrinho.quantidadeXSalada()
                    carrinho.exibirCarrinho()
                    adicionarMaisProduto()
                }
                else -> {
                    println("Opção inválida, tente novamente")
                    menuLanche()
                }
            }
        } catch (ex: Exception) {
            ex.toString()
            println("Porfavor digite apena numero não a letras")
            menuLanche()
        }

    }

    private fun menuBebida() {
        try {
            println("Qual bebida quer levar?:")
            println(
                "[1] -> Refrigerante\n" +
                        "[2] -> Suco"
            )
            opcaoBebida = readln().toInt()
            when {
                opcaoBebida == 1 -> {
                    println("-------- Refrigerante ---------")
                    carrinho.quantidadeRefri()
                    carrinho.exibirCarrinho()
                    adicionarMaisProduto()

                }
                opcaoBebida == 2 -> {
                    "-------- Suco --------"
                    carrinho.quantidadeSuco()
                    carrinho.exibirCarrinho()
                    adicionarMaisProduto()
                }
                else -> {
                    println("Opção inválida, tente novamente")
                    menuBebida()
                }
            }
        } catch (ex: Exception) {
            ex.toString()
            println("Por favor degite apena numero")
            menuBebida()
        }
    }

    fun adicionarMaisProduto() {
        try {
            println("Quer mais item? [1] -> sim [2] -> não")
            var maisItem = readln().toInt()
            if (maisItem == 1 || maisItem == 2) {
                when (maisItem) {
                    1 -> menu()
                    2 -> {
                        menuContinuaOuNão()
                    }
                }
            } else {
                println("numero inválido! Porfavor digite 1 ou 2")
                adicionarMaisProduto()
            }
        } catch (ex: Exception) {
            ex.toString()
            println("Porfavor digite apena numero não a letras")
            adicionarMaisProduto()
        }
    }

    fun menuContinuaOuNão() {
        try {
            println("Oque mais..")
            println(
                "[1] -> voltar ao menu?\n" +
                        "[2] -> Quer Editar um item?\n" +
                        "[3] -> Quer retirar um item?\n" +
                        "[4] -> ou Finalizar"
            )
            var opcaoMenu = readln().toInt()

            when {
                opcaoMenu == 1 -> {
                    menu()
                }
                opcaoMenu == 2 -> {
                    carrinho.editarItem()
                    carrinho.exibirCarrinho()
                    menuContinuaOuNão()
                }
                opcaoMenu == 3 -> {
                    carrinho.removerItem()
                    carrinho.exibirCarrinho()
                    menuContinuaOuNão()
                }
                opcaoMenu == 4 -> {
                    carrinho.exibirCarrinho()
                    carrinho.pagamento()
                }
                opcaoMenu < 0 || opcaoMenu > 4 ->{
                    println("Numero opção inválido")
                    menuContinuaOuNão()
                }
            }
        } catch (ex: Exception) {
            ex.toString()
            println("Porfavor digite apena numero não a letras")
            menuContinuaOuNão()
        }
    }
}