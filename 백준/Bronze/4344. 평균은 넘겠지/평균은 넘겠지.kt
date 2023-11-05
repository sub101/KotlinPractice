import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val C = nextInt()
    
    repeat(C) {
        val N = nextInt()
        var student = Array(N) { 0 }
        
        for (i in 0 until N) {
            student[i] = nextInt()
        }
        
        var score = 0
        student.forEach { score += it }
        
        val average = score / student.size
        val overAvg = student.filter { it > average }.count()
        val result = String.format("%.3f", (overAvg.toFloat() / N * 100).toDouble()) + "%"
        println(result)
    }
}