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

data class Estatisticas(val minValor: Int, val maxValor: Int, val mediaTotal: Double , val mediaParcial: Double )

fun verificarVazio(listaInteiros: ArrayList<Int>) {
    if (listaInteiros.isEmpty()) throw IllegalArgumentException("Insira uma lista com elementos")
}

//tailrec fun factorial(n: Long, accum: Long = 1): Long {
//    val soFar = n * accum
//    return if (n <= 1) {
//        soFar
//    } else {
//        factorial(n - 1, soFar)
//    }
//}



tailrec fun getEstatisticas(listaInteiros: ArrayList<Int>,
                            indice: Int = 0,
                            soma: Double = 0.0,
                            estatisticas: Estatisticas =
                                Estatisticas(
                                    listaInteiros[0],
                                    listaInteiros[0],
                                    0.0,
                                    0.0
                                )): Estatisticas {
    verificarVazio(listaInteiros)


    return if (indice == listaInteiros.count()) {
        val mediaParcial = soma / indice
        val mediaTotal = soma / listaInteiros.count()
        estatisticas.copy(mediaTotal = mediaTotal, mediaParcial = mediaParcial)
    } else {
        val valor = listaInteiros[indice]
        val newSoma = soma + valor

        val menorValor = if (valor < estatisticas.minValor) valor else estatisticas.minValor
        val maxValor = if (valor > estatisticas.maxValor) valor else estatisticas.maxValor
        val mediaParcial = newSoma / (indice + 1)
        val mediaTotal = newSoma / listaInteiros.count()
        //TODO: revisar
        getEstatisticas(
            listaInteiros,
            indice + 1,
            newSoma,
            estatisticas.copy(
                minValor = menorValor,
                maxValor = maxValor,
                mediaTotal = mediaTotal,
                mediaParcial = mediaParcial
            )
        )
    }
}
//    for (valor in listaInteiros) {
//         soma += valor
//        if (valor < minValor) {
//            minValor = valor
//        }
//        if (valor > maxValor) {
//            maxValor = valor
//        }
//    }
//    media = soma / listaInteiros.count()
//    return Estatisticas(minValor, maxValor, media)


fun main(){

    val numeros = arrayListOf(6,9,15,-2,92,11)

    val (min: Int, max: Int, mediaTotal: Double, mediaParcial: Double) = getEstatisticas(numeros)



    println("numeros $numeros")

    println("O tamanho da lista é de ${numeros.count()} elementos")
    println("O menor valor da lista é: $min.")
    println("O maior valor da lista é: $max.")
    println("A média dos valores da lista é: $mediaTotal.")
    println("A média parcial dos valores da lista é: $mediaParcial.")

}
