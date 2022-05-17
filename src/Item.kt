class Item (val codigo: String,
           val nome:String,
           val valor:Double,
           var qtdade:Int,
            var calculo: Double,
            var novoItens: Int,
           var vendido:Boolean ) {
   // private val listaitem: MutableList<Item> = mutableListOf()

    override fun toString(): String {
        return "código: $codigo | nome: $nome | preço(R$) $calculo";
    }
}