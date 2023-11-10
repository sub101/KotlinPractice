import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val arr = IntArray(5)
    
    for (i in 0 until 5) {
        arr[i] = nextInt()
    }
    
    val result = arr.sorted()
    
    println(result.sum() / 5)
    print(result[2])
}