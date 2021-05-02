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

fun main(){

    val numeros = arrayListOf(6,9,15,-2,92,11)

    var tamanho = numeros.count()


    println("numeros ${numeros}")

    println("O tamanho da lista é de $tamanho elementos")

}