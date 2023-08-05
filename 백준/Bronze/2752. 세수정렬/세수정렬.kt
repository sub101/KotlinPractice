import java.util.Scanner

fun main(args: Array<String>) {
    val s = Scanner(System.`in`)
    val n1 = s.nextInt()
    val n2 = s.nextInt()
    val n3 = s.nextInt()

    val mutableList = mutableListOf(n1, n2, n3)
    mutableList.sort()

    for (i in 0 until mutableList.size) {
        print(mutableList[i])
        print(" ")
    }
}