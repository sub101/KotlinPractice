import kotlin.math.*

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
        val n = readln().toInt()
        val planet: Array<Triple<Int, Int, Int>> = Array(n) { Triple(0, 0, 0) }
        var cnt = 0
        repeat(n) { idx ->
            val info = readln().split(" ").map { it.toInt() }
            planet[idx] = Triple(info[0], info[1], info[2])
        }
        planet.forEach {
            if (!(isContain(x1, y1, it) && isContain(x2, y2, it)) && (isContain(x1, y1, it) || isContain(x2, y2, it))) cnt++
        }
        println(cnt)
    }
}

private fun isContain(a1: Int, b1: Int, circle: Triple<Int, Int, Int>): Boolean {
    return getDistance(a1, b1, circle.first, circle.second) < circle.third
}

private fun getDistance(a1: Int, b1: Int, a2: Int, b2: Int): Double {
    return sqrt((a2 - a1).toDouble().pow(2) + (b2 - b1).toDouble().pow(2))
}