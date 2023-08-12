fun main(args: Array<String>) {
    val input = readLine()!!.split(' ')
    val s1 = input[0]
    val s2 = input[1]

    var str = StringBuilder(s1).append(s2).toString()
    println(str)
}