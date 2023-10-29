import java.util.*

private var n = 0
private var m = 0
private lateinit var arr : Array<IntArray>
private val dx = listOf(0,-1,-1,-1,0,1,1,1)
private val dy = listOf(-1,-1,0,1,1,1,0,-1)
private lateinit var clouds : LinkedList<Pair<Int,Int>>
private lateinit var cloudChecks : Array<BooleanArray>
fun main() {
    val br = System.`in`.bufferedReader()
    br.readLine().split(" ").map { it.toInt() }.apply {
        n = this[0]
        m = this[1]
    }
    arr = Array(n){ IntArray(n) }
    cloudChecks = Array(n){ BooleanArray(n) }
    repeat(n){
        arr[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    clouds = LinkedList()
    initClouds()
    for(i in 0 until m){
        val (d,s) = br.readLine().split(" ").map { it.toInt() }
        moveClouds(d,s)
        rainAndWater()
        makeClouds()
    }
    var result = 0
    for(i in 0 until n){
        for(j in 0 until n){
            result += arr[i][j]
        }
    }
    println(result)
}
private fun moveClouds(d:Int,s:Int){
    for(i in 0 until clouds.size){
        val (x,y) = clouds.pollFirst()
        var nx = x + dx[d-1]*(s%n)
        var ny = y + dy[d-1]*(s%n)
        if(nx>= n) nx -= n
        if(ny>= n) ny -= n
        if(nx<0) nx += n
        if(ny<0) ny += n
        cloudChecks[nx][ny] = true
        clouds.addLast(Pair(nx,ny))
    }
}
private fun rainAndWater(){
    for(i in 0 until clouds.size){
        val (x,y) = clouds.pollFirst()
        arr[x][y] += 1
        clouds.addLast(Pair(x,y))
    }
    for(j in 0 until clouds.size){
        val (x,y) = clouds.pollFirst()
        var cnt = 0
        for(i in 1 .. 7 step 2){
            val nx = x + dx[i]
            val ny = y + dy[i]
            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue
            if(arr[nx][ny] > 0) cnt += 1
        }
        arr[x][y] += cnt
    }
}
private fun makeClouds(){
    for(i in 0 until n){
        for(j in 0 until n){
            if(cloudChecks[i][j]){
                cloudChecks[i][j] = false
            }
            else if(arr[i][j]>= 2) {
                clouds.add(Pair(i, j))
                arr[i][j] -= 2
            }
        }
    }
}
private fun initClouds(){
    clouds.add(Pair(n-1,0))
    clouds.add(Pair(n-2,0))
    clouds.add(Pair(n-1,1))
    clouds.add(Pair(n-2,1))
}