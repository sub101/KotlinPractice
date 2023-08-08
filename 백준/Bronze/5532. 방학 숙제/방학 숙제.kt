import java.util.Scanner

fun main() {
    val s = Scanner(System.`in`)

    val L = s.nextInt()
    val A = s.nextInt()
    val B = s.nextInt()
    val C = s.nextInt()
    val D = s.nextInt()
    val result: Int

    var korean = A / C
    if (A % C != 0) {
        ++korean
    }

    var math = B / D
    if (B % D != 0) {
        ++math
    }

    if (korean >= math) {
        result = L - korean
    } else {
        result = L - math
    }

    println(result)
}