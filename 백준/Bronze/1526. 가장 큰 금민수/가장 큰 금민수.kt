import kotlin.math.max

var n = 0
var res = 0

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    dfs(0)
    println(res)
}

fun dfs(sum: Int) {
    if (sum > n) return
    dfs(sum * 10 + 7)
    dfs(sum * 10 + 4)
    res = max(res, sum)
}