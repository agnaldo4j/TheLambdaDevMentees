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
fun mediaValores(listaInteiros: ArrayList<Int>): Double {
    var soma: Double = 0.0
    for (valor in listaInteiros) {
        soma += valor
    }
    val media: Double = soma / listaInteiros.count()
    return media
}

fun achaMenorValor(listaInteiros: ArrayList<Int>): Int {
    var minValor: Int = listaInteiros[0]
    for (valor in listaInteiros){
        if (valor < minValor) {
            minValor = valor
        }
    }
    return minValor
}

fun achaMaiorValor(listaInteiros: ArrayList<Int>): Int{
    var maxValor: Int = listaInteiros[0]
    for (valor in listaInteiros){
        if (valor > maxValor) {
            maxValor = valor
        }
    }
    return maxValor
}

fun main(){

    val numeros = arrayListOf(6,9,15,-2,92,11)

    val tamanho = numeros.count()
    val min = achaMenorValor(numeros)
    val max = achaMaiorValor(numeros)
    val media = mediaValores(numeros)

    println("numeros ${numeros}")

    println("O tamanho da lista é de $tamanho elementos")
    println("O menor valor da lista é: $min.")
    println("O maior valor da lista é: $max.")
    println("A media dos valores da lista é: $media.")

}