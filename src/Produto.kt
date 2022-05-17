interface Produto {
    val codigo: String
    val nome: String
    var qtdade:Int
    val valor: Double
    var calculo: Double
    var resultadolanche:Double
    var opcaoMenu:Int
    var novoQtdade: Double
    var novoItens: Int

    fun qtdadeItem()
    fun resultado()
    fun exibirResultado()
    fun removerItem()
    fun adicionarMaisItens()
    fun verificarCodigo()
    fun menuContinuaOuNão()
}