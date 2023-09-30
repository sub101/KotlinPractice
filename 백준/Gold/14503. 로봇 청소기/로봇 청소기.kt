import java.util.StringTokenizer

fun main(args:Array<String>) {

    val dx = arrayOf(-1,0,1,0)
    val dy = arrayOf(0,1,0,-1)

    val (n,m) = readln().split(" ").map{it.toInt()}
    var (robotX,robotY,robotD) = readln().split(" ").map{it.toInt()}

    val map = Array(n){
        val st = StringTokenizer(readln())
        Array(m){st.nextToken().toInt()}
    }

    var count = 0

    turn@while (true){
        if (map[robotX][robotY] == 0) {
            map[robotX][robotY] = -1
            count ++
        } else if (map[robotX][robotY] ==1){
            break@turn
        }
        for (i in 0 until 4) {
            if (--robotD == -1) robotD = 3

            val nx = robotX + dx[robotD]
            val ny = robotY + dy[robotD]

            if (map[nx][ny] == 0) {
                robotX = nx
                robotY = ny
                continue@turn
            }
        }

        robotX -= dx[robotD]
        robotY -= dy[robotD]
    }
    println(count)
}
