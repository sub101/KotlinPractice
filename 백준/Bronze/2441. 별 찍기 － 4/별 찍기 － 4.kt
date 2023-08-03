import java.util.Scanner

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val n = s.nextInt()
    for (i in 1..n) {
        for (k in 1..n) {
            if (k < i) {
                print(" ")
            } else {
                print("*")
            }
        }
        println()
    }
}