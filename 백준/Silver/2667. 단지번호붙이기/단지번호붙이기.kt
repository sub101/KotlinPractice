import java.util.*
 
data class Point(val x: Int, val y: Int)
 
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
 
    val dx = arrayOf(1, 0, -1, 0)
    val dy = arrayOf(0, 1, 0, -1)
 
    val num = br.readLine().toInt()
    val graph = Array(num){ IntArray(num) }
    val visited = Array(num){ BooleanArray(num) }
    val ans = mutableListOf<Int>() 
 
    for(i in 0 until num) {
        val line = br.readLine()
        for(j in 0 until num) {
            graph[i][j] = line[j] - '0'
        }
    }
 
    fun bfs(x: Int, y: Int) {
        val queue : Queue<Point> = LinkedList()
        visited[x][y] = true
        ans[ans.size-1]++
        queue.add(Point(x, y))
 
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
 
            for(i in 0 until 4) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]
 
                if(nx < 0 || nx >= num || ny < 0 || ny >= num) continue
                if(visited[nx][ny]) continue
 
                if(graph[nx][ny] == 1) {
                    visited[nx][ny] = true
                    ans[ans.size-1]++
                    queue.add(Point(nx, ny))
                }
            }
        }
    }
 
    for(i in 0 until num) {
        for(j in 0 until num) {
            if(visited[i][j]) continue
            if(graph[i][j] == 1) { 
                ans.add(0)
                bfs(i,j)
            }
        }
    }
 
    ans.sort()
 
    bw.append("${ans.size}\n")
    ans.forEach {
        bw.append("$it\n")
    }
 
    bw.write("")
    bw.flush()
    bw.close()
    br.close()
}