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

data class Estatisticas(val minValor: Int, val maxValor: Int, val media: Double )

fun verificarVazio(listaInteiros: ArrayList<Int>) {
    if (listaInteiros.isEmpty()) throw IllegalArgumentException("Insira uma lista com elementos")
}

fun getEstatisticas(listaInteiros: ArrayList<Int>): Estatisticas{
    verificarVazio(listaInteiros)

    var soma = 0.0
    var media = 0.0
    var minValor = listaInteiros[0]
    var maxValor = listaInteiros[0]

    for (valor in listaInteiros) {
         soma += valor
        if (valor < minValor) {
            minValor = valor
        }
        if (valor > maxValor) {
            maxValor = valor
        }
    }
    media = soma / listaInteiros.count()
    return Estatisticas(minValor, maxValor, media)
}

fun main(){

    val numeros = arrayListOf(6,9,15,-2,92,11)

    val (min: Int, max: Int, media: Double) = getEstatisticas(numeros)



    println("numeros $numeros")

    println("O tamanho da lista é de ${numeros.count()} elementos")
    println("O menor valor da lista é: $min.")
    println("O maior valor da lista é: $max.")
    println("A média dos valores da lista é: $media.")

}
