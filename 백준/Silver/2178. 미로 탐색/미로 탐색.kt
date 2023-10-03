import java.util.*

//좌표를 담을 클래스
data class Node(val x: Int, val y: Int)

// 방향을 담을 변수 - 상하좌우
val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun main(args: Array<String>) {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val map = Array(n) { Array(m) { 0 } }

    repeat(n) { x ->
        val line = readln()
        repeat(m) { y ->
            map[x][y] = line[y] - '0'
        }
    }

    bfs(n, m, map)

}

fun bfs(n: Int, m: Int, map: Array<Array<Int>>) {
    val q: Queue<Node> = LinkedList()
    val visited = Array(n) { Array(m) { 1 } }

    //bfs에 사용할 q 선언 / 0,0좌표를 큐에 넣음
    q.offer(Node(0, 0))
    visited[0][0] = 1 //방문 여부를 담을 visited 선언

    //q에서 하나씩 원소를 빼며 반복문을 진행
    while (q.isNotEmpty()) {
        val target = q.poll()

        //4번 (상하좌우) 반복문 돌림
        for (i in 0 until 4) {
            val nx = target.x + dx[i]
            val ny = target.y + dy[i]

            // 만약 새 좌표(nx,ny)가 맵 범위를 벗어날 경우, 방문이 불가능할 경우 (0,벽), 이미 방문한 좌표의 경우 visited[nx][ny] != 1 다음 회차로 넘김
            if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] == 0 || visited[nx][ny] != 1)
                continue

            // 그렇지 않다면 해당 좌표를 큐에 집어넣고, 방문처리
            q.offer(Node(nx, ny))
            //이때, 해당좌표까지의 거리를 visited에 저장
            visited[nx][ny] = visited[target.x][target.y] + 1

            // 만약 목표 좌표에 도달했다면, 반복문을 끝내고 해당 좌표까지의 거리를 출력
            // bfs의 경우 해당 좌표를 처음 방문했을 때, 그 좌표까지의 거리가 최단경로
            if (nx == n - 1 && ny == m - 1) {
                println(visited[nx][ny])
                break
            }
        }
    }
}

