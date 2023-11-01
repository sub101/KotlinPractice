import java.util.Scanner
import kotlin.math.*

fun main() = with(Scanner(System.`in`)) {
    val first = nextInt()
    val second = nextInt()
    val third = nextInt()
    var total = 0
    
    if (first == second && first == third) {
        total = 10000 + first * 1000
    } else if (first == second || first == third) {
        total = 1000 + first * 100
    } else if (second == third) {
        total = 1000 + second * 100
    } else {
        total = listOf(first, second, third).max() * 100
    }
    
    print("$total")
}