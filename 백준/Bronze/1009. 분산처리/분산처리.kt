import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    repeat(nextInt()) {
        val a = nextInt()
        val b = nextInt()
        var c = 0
        var ans = 1

        if (a % 10 == 0 || a % 10 == 1 || a % 10 == 5 || a % 10 == 6) ans = a % 10
        else if (a % 10 == 4 || a % 10 == 9) c = if (b % 2 == 0) 2 else b % 2
        else c = if (b % 4 == 0) 4 else b % 4

        for (i in 0 until c) ans = (ans * a) % 10

        if (ans == 0) ans = 10
        println(ans)
    }
}