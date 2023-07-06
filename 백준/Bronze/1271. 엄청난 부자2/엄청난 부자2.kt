class Main {
}

fun main(args:Array<String>) = with(System.`in`.bufferedReader()){
    val input = readLine()
    val values = input.split(" ")

    var n = values[0].toBigInteger() // 최씨가 가진 돈 n
    var m = values[1].toBigInteger() // 돈 받을 생명체 수

    println(n/m)
    println(n%m)
}