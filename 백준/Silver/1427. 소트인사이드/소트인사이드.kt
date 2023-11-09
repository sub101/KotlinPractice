fun main() {
    val number = readLine()!!.toInt()
    val sortedDigits = number.toString().toCharArray().sortedDescending().joinToString("")
    println(sortedDigits)
}