class Xburguer() : Produto {
    val pegarClasseMenu = Menu()
    override var codigo = ""
    override val nome = "X-burguer"
    override val valor = 10.00
    override var calculo = 0.0
    override var qtdade = 0
    override var opcaoMenu = 0
    var opcaoFormaPagamento = 0
    override var novoQtdade = 0.0
    override var novoItens = 0

    private val listaItem: ArrayList<Item> = ArrayList()
    private val dicionario: HashMap<Int, List<Item>> = HashMap()
    private var identificador: Int = 0
    internal fun guardarPecas(listaDePeca: ArrayList<Item>): Int {
        dicionario[identificador] = listaDePeca
        identificador++
        return identificador - 1
    }

    override var resultadolanche: Double = 0.0
        get() = field

    override fun qtdadeItem(){
        println("Codigo:")
        codigo = readln()
        println("Quantos X-Burguer você quer leva:?")
        qtdade = readln().toInt()
        val item: Item = Item(codigo,nome,valor,qtdade,calculo,novoItens,vendido = false)
        listaItem.add(item)
        resultado()
    }

    override fun adicionarMaisItens(){
        calculo += novoQtdade
        exibirResultado()
    }

    override fun resultado(){
        calculo = 10.00 * qtdade
       // val item: Item = Item("",nome,valor,qtdade,calculo,vendido = false)
       // listaItem.add(item)
      //  exibirResultado()
        menuContinuaOuNão()
    }

    override fun exibirResultado(){
        listaItem.forEach{
            println("Codigo | Nome | Quantidade | valor | Total")
            println("${it.codigo}------${it.nome}-----$qtdade------R$ ${it.valor}------R$ $calculo")

        }

    }

    override fun verificarCodigo() {
        print("Qual o código? ")
        val buscarCodigo = readln()
        for (item in listaItem) {
            if (buscarCodigo == item.codigo && !item.vendido) {
                println("${item.codigo} $nome esta na lista")
                println("Quantos quer adicionar mais?")
                novoItens = readln().toInt()
                novoQtdade = 10.00 * novoItens
                qtdade += novoItens
                adicionarMaisItens()
            } else {
                println("codigo não foi encontrado")
            }
        }
        menuContinuaOuNão()
    }
    fun listarItens() {
        if (listaItem.isEmpty()) {
            println("Não temos nenhum item cadastrado no momento")
        } else {
            println("Atualmente temos os seguintes itens: ${listaItem.toString()}");
        }
    }

    override fun removerItem() {
        print("Qual o código de produto para retirar? ")
        val codigoDigitado = readln()
        for (item in listaItem) {
            if (codigoDigitado == item.codigo && !item.vendido) {
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

    override fun menuContinuaOuNão(){
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
            opcaoMenu == 4 ->{exibirResultado()
                                 finalizacao()}
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