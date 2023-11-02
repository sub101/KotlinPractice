import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val arrX = IntArray(N)
    val arrY = IntArray(N)
    
    for(i in 0 until N){
        val x = nextInt()
        val y = nextInt()
        arrX[i] = x
        arrY[i] = y
    }
    
    val arrXY = arrX.zip(arrY)
    val result = arrXY.sortedWith(compareBy({ it.first }, { it.second }))

    for (row in result) {
        print("${row.first} ${row.second}")
        println()
    }
}