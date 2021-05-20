package teste.app


/*
Your task is to process a sequence of integer numbers to determine the following statistics:

    o) minimum value
    o) maximum value
    o) number of elements in the sequence
    o) average value

For example: [6, 9, 15, -2, 92, 11]

    o) minimum value = -2
    o) maximum value = 92
    o) number of elements in the sequence = 6
    o) average value = 21.833333
 */
//class TesteAula0205 {


//}

//number of elements in the sequence

data class Estatisticas(val minValor: Int, val maxValor: Int, val mediaTotal: Double = 0.0, val mediaParcial: Double = 0.0) {

    fun encontraMenorValor(valor: Int) = if (valor < minValor) valor else minValor
    fun encontraMaiorValor(valor: Int) = if (valor > maxValor) valor else maxValor

    companion object {
        fun estadoInicial(listaInteiros: ArrayList<Int>) = Estatisticas(minValor = listaInteiros[0], maxValor = listaInteiros[0])
    }
}

data class EstatisticaState(val listaInteiros: ArrayList<Int>,
                            val indice: Int = 0,
                            val soma: Double = 0.0,
                            val estatisticas: Estatisticas = Estatisticas.estadoInicial(listaInteiros)) {
    fun eUltimaIteracao() = indice == listaInteiros.count()

    fun calculaEstadoFinal() = estatisticas.copy(
            mediaTotal = soma / listaInteiros.count(),
            mediaParcial = soma / indice
    )

    fun calculaEstadoIntermediario(): EstatisticaState {

        val valor = listaInteiros[indice]
        val newSoma = soma + valor
        val proximoIndice = indice + 1

        return this.copy(
                indice = proximoIndice,
                soma = newSoma,
                estatisticas = estatisticas.copy(
                        minValor = estatisticas.encontraMenorValor(valor),
                        maxValor = estatisticas.encontraMaiorValor(valor),
                        mediaTotal = newSoma / listaInteiros.count(),
                        maxParcial = newSoma / proximoIndice
                )
        )
    }
}

fun verificarVazio(listaInteiros: ArrayList<Int>) {
    if (listaInteiros.isEmpty()) throw IllegalArgumentException("Insira uma lista com elementos")
}

tailrec fun getEstatisticas(estatisticaState: EstatisticaState): Estatisticas {
    verificarVazio(listaInteiros)
    return if (estatisticaState.eUltimaIteracao()) estatisticaState.calculaEstadoFinal()
    else getEstatisticas(estatisticaState.calculaEstadoIntermediario())
}

fun main() {

    val numeros = arrayListOf(6, 9, 15, -2, 92, 11)
    val (min: Int, max: Int, mediaTotal: Double, mediaParcial: Double) = getEstatisticas(numeros)

    println("numeros $numeros")
    println("O tamanho da lista é de ${numeros.count()} elementos")
    println("O menor valor da lista é: $min.")
    println("O maior valor da lista é: $max.")
    println("A média dos valores da lista é: $mediaTotal.")
    println("A média parcial dos valores da lista é: $mediaParcial.")

}
