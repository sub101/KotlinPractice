import java.util.*

private var n = 0
private var m = 0
private lateinit var arr : Array<CharArray>
private lateinit var visited : Array<Array<Array<BooleanArray>>>
private val dx = listOf(-1,0,1,0)
private val dy = listOf(0,1,0,-1)
private lateinit var red : Pair<Int,Int>
private lateinit var blue : Pair<Int,Int>
private lateinit var queue : Queue<Triple<Pair<Int,Int>,Pair<Int,Int>,Int>>

fun main() {
    val br = System.`in`.bufferedReader()
    br.readLine().split(" ").map { it.toInt() }.apply {
        n = this[0]
        m = this[1]
    }
    arr = Array(n) { CharArray(m) }
    visited = Array(n) { Array(m){ Array(n){BooleanArray(m)} } }
    queue = ArrayDeque()
    repeat(n){
        arr[it] = br.readLine().toCharArray()
        arr[it].forEachIndexed { idx,s ->
            if(s == 'R')
                red = Pair(it,idx)
            if(s == 'B')
                blue = Pair(it,idx)
        }
    }
    queue.add(Triple(red,blue,0))
    visited[red.first][red.second][blue.first][blue.second] = true
    bfs()

}
private fun bfs(){
    while(queue.isNotEmpty()){
        val q = queue.poll()
        val (redX,redY) = q.first
        val (blueX,blueY) = q.second
        val cnt = q.third
        if(cnt >= 10) break
        for(i in 0 .. 3){
            var (nnRedX,nnRedY,redCnt)=move(Pair(redX,redY),i)
            var (nnBlueX,nnBlueY,blueCnt)=move(Pair(blueX,blueY),i)
            if(arr[nnRedX][nnRedY]=='O' && arr[nnBlueX][nnBlueY]!='O'){
                println(1)
                return
            }
            if(arr[nnBlueX][nnBlueY]=='O') {
                continue
            }
            if(nnRedX == nnBlueX && nnRedY == nnBlueY){
                if(redCnt>blueCnt){
                    nnRedX -= dx[i]
                    nnRedY -= dy[i]
                }
                else {
                    nnBlueX -= dx[i]
                    nnBlueY -= dy[i]
                }
            }
            if(visited[nnRedX][nnRedY][nnBlueX][nnBlueY]) continue
            visited[nnRedX][nnRedY][nnBlueX][nnBlueY] = true
            queue.add(Triple(Pair(nnRedX,nnRedY), Pair(nnBlueX,nnBlueY),cnt+1))
        }
    }
    println(0)
}
private fun move(point:Pair<Int,Int>,dir:Int):Triple<Int,Int,Int>{
    var (x, y) = point
    var cnt = 0
    while(arr[x+dx[dir]][y+dy[dir]] != '#' && arr[x][y]!= 'O'){
        x += dx[dir]
        y += dy[dir]
        cnt += 1
    }
    return Triple(x,y,cnt)
}