class Menu {
    var opcao = 0
    var opcaoLanche = 0
    var opcaoBebida = 0


    fun menu(){

        println("Oque você quer comprar:?")
        println("[1] - Lanche\n" +
                "[2] - Bebida")
        opcao = readln().toInt()


try {
        when{
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
    }catch (ex : Exception){
        ex.toString()
        println("Não aceito letras apena numeros")
        menu()
    }
    }


    fun menuLanche() {
        println("Qual lanche gostaria adicionar?:")
        println(
            "[1] -> X-burguer\n" +
                    "[2] -> X-salada"
        )
        opcaoLanche = readln().toInt()

        try {
            when {
                opcaoLanche == 1 -> {
                    println("-------- X - Burguer ---------")
                    Xburguer().qtdadeItem()
                }
                opcaoLanche == 2 -> {
                    "-------- X - Salada --------"
                    Xsalada().qtdadeItem()
                }
                else -> {
                    println("Opção inválida, tente novamente")
                    menuLanche()
                }
            }
        }catch (ex : Exception){
            ex.toString()
            println("Porfavor digite apena numero não a letras")
            menuLanche()
        }

    }

    fun menuBebida(){
        println("Qual bebida quer levar?:")
        println("[1] -> Refrigerante\n" +
                "[2] -> Suco")
        opcaoBebida = readln().toInt()

        try {
            when {
                opcaoBebida == 1 -> {
                    println("-------- Refrigerante ---------")
                    Refri().qtdadeItem()
                }
                opcaoBebida == 2 -> {
                    "-------- Suco --------"
                    Suco().qtdadeItem()
                }
                else -> {
                    println("Opção inválida, tente novamente")
                    menuBebida()
                }
            }
        }catch (ex : Exception){
            ex.toString()
            println("Por favor degite apena numero")
            menuBebida()
        }
    }
}