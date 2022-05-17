class Refri() :Produto{
    override var opcaoMenu: Int = 0
    var opcaoFormaPagamento = 0
    override var novoQtdade: Double = 0.0
    override var codigo = ""
    override val nome: String = "Refrigerante"
    override var qtdade: Int = 0
    override val valor: Double = 8.00
    override var calculo: Double = 0.0
    override var resultadolanche: Double = 0.0
    override var novoItens = 0
    val listaItem: ArrayList<Item> = ArrayList()
    val pegarClasseMenu = Menu()

    override fun qtdadeItem() {
        println("Codigo:")
        codigo = readln()
        println("Quantos refrigerante você quer leva:?")
        qtdade = readln().toInt()
        val item: Item = Item(codigo,nome,valor,qtdade,calculo,novoItens,vendido = false)
        listaItem.add(item)
        resultado()
    }

    override fun resultado() {
        calculo = 8.00 * qtdade
//        val item: Item = Item(codigo,nome,valor,qtdade,calculo, vendido = false)
//        listaItem.add(item)
        menuContinuaOuNão()
    }

    override fun exibirResultado() {
        listaItem.forEach{
            println("Codigo | Nome | Quantidade | valor | Total")
            println("$codigo------$nome-----$qtdade------R$ $valor------R$ $calculo")
        }
    }

    override fun removerItem() {
        print("Qual o código de produto para retirar? ")
        val codigoDigitado = readln()
        for (item in listaItem) {
            if (codigoDigitado == item.codigo && !item.vendido) {
                item.vendido = true
                println("Lista ${nome} já esta retirado")
                menuContinuaOuNão()
            } else if (codigoDigitado == item.codigo) {
                println("Estoque esta vazio")
            } else {
                println("Opção invalido")
                removerItem()
            }
            break
        }
    }
    override fun adicionarMaisItens() {
        calculo += novoQtdade
        exibirResultado()
    }

    override fun verificarCodigo() {
        print("Qual o código? ")
        val buscarCodigo = readln()
        for (item in listaItem) {
            if (buscarCodigo == item.codigo && !item.vendido) {
                println("${item.codigo} $nome esta na lista")
                println("Quantos quer adicionar mais?")
                novoItens = readln().toInt()
                novoQtdade = 8.00 * novoItens
                qtdade += novoItens
                adicionarMaisItens()
            } else {
                println("codigo não foi encontrado")
            }
        }
        menuContinuaOuNão()
    }

    override fun menuContinuaOuNão() {
        println("Oque mais..")
        println("[1] -> voltar ao menu?\n" +
                "[2] -> Quer Editar um item?\n" +
                "[3] -> Quer retirar um item?\n" +
                "[4] -> ou Finalizar")
        opcaoMenu = readln().toInt()

        when{
            opcaoMenu == 1 ->{ pegarClasseMenu.menu() }
            opcaoMenu == 2 ->{ verificarCodigo() }
            opcaoMenu == 3 ->{removerItem()}
            opcaoMenu == 4 ->{exibirResultado()}
        }
    }
    fun trocoDinheiro(){
        println("Qual valor você possui dinheiro?")
        var valor = readln().toDouble()
        var desconto = calculo - valor
        println("Troco: $desconto")
        println("Compra finalizada com sucesso! Boa refeição")
    }

    fun finalizacao(){
        println("Qual forma pagamento?\n" +
                "[1] -> Cartão Debito\n" +
                "[2] -> Cartão Credito\n" +
                "[3] -> Cartão Refeição\n" +
                "[4] -> Dinheiro")
        opcaoFormaPagamento = readln().toInt()

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