import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    var nums = ArrayList<Int>()
    
    for (i in 0 until 9) {
        nums.add(nextInt())
    }
    
    print("${nums.max()} ${nums.indexOf(nums.max()) + 1}")
}