package teste.app

class TesteAula2804 {
    fun soma(numOne:Int, numTwo:Int): Int {
        return  numOne + numTwo
    }
}

fun main() {
    val objClass = TesteAula2804()


    //TODO: remover duplicidade
    var primInt: Int?
    do {
        print("Digite o primeiro número: ")
        primInt = readLine()?.also({ linha ->
            println(linha)
        })?.trim()?.toIntOrNull()
    } while (primInt == null)

    var segInt: Int?
    do {
        print("Digite o segundo número: ")
        segInt = readLine()?.trim()?.toIntOrNull()
    } while (segInt == null)

    println("O resultado da soma de $primInt com $segInt é ${objClass.soma(primInt, segInt)}.")

}