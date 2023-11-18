import kotlin.math.min

var answer = Int.MAX_VALUE

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val map = ArrayList<IntArray>()
    val cameras = ArrayList<Camera>()
    repeat(n) { r ->
        val arr = readln().split(" ").map { it.toInt() }.toIntArray()
        arr.forEachIndexed { c, i ->
            if (i in 1 .. 5) {
                cameras.add(Camera(i, r, c))
            }
        }
        map.add(arr)
    }

    dfs(map, cameras, 0)

    println(answer)
}

fun dfs(map: ArrayList<IntArray>, cameras: ArrayList<Camera>, cameraNumber: Int) {
    if (cameras.size == 0) { // 카메라 한 대도 없을 때 Array OutOfBound 에러 방지
        answer = countZeros(map)
        return
    }

    for (direction in 0 until cameras[cameraNumber].directionCount()) { // 카메라 회전 가능 경우의 수 (1번 카메라는 4개, 5번 카메라는 1개)
        val newMap = ArrayList<IntArray>()
        map.forEach { newMap.add(it.clone()) }

        cameras[cameraNumber].simulate(newMap, direction) // 이 카메라가 현재 바라보고 있는 방향에 대해 쳐다볼 수 있는 곳을 7로 칠한다

        if (cameraNumber == cameras.lastIndex) { // dfs의 depth가 마지막일 때 최종적으로 맵에서 0의 개수를 세어서 역대 최소값이면 answer에 넣는다
            answer = min(answer, countZeros(newMap))
        }

        for (i in cameraNumber + 1 until cameras.size) { // 이 카메라 뒤에 있는 카메라들을 회전시키는 경우의 수들을 전부 테스트한다
            dfs(newMap, cameras, i)
        }

    }

}

// 맵에 있는 0의 개수를 구한다
fun countZeros(map: ArrayList<IntArray>): Int {
    var count = 0
    for (arr in map) {
        for (i in arr) {
            if (i == 0) {
                count++
            }
        }
    }

    return count
}


class Camera(val type: Int, val r: Int, val c: Int) {

    fun simulate(map: ArrayList<IntArray>, direction: Int) {
        when(type) {
            1 -> {
                checkForward(map, direction)
            }
            2 -> {
                if (direction == 0) { checkForward(map, 0); checkForward(map, 2); }
                else if (direction == 1) { checkForward(map, 1); checkForward(map, 3); }
            }
            3 -> {
                if (direction == 0) { checkForward(map, 0); checkForward(map, 1);}
                else if (direction == 1) { checkForward(map, 1); checkForward(map, 2); }
                else if (direction == 2) { checkForward(map, 2); checkForward(map, 3); }
                else if (direction == 3) { checkForward(map, 0); checkForward(map, 3); }
            }
            4 -> {
                if (direction == 0) { checkForward(map, 0); checkForward(map, 1); checkForward(map, 3); }
                else if (direction == 1) { checkForward(map, 0); checkForward(map, 1); checkForward(map, 2); }
                else if (direction == 2) { checkForward(map, 1); checkForward(map, 2); checkForward(map, 3); }
                else if (direction == 3) { checkForward(map, 0); checkForward(map, 2); checkForward(map, 3); }
            }
            5 -> {
                checkForward(map, 0); checkForward(map, 1); checkForward(map, 2); checkForward(map, 3);
            }
        }
    }

    private fun checkForward(map: ArrayList<IntArray>, direction: Int) {
        val dr = intArrayOf(-1, 0, 1, 0)
        val dc = intArrayOf(0, 1, 0, -1)

        var nextR = r
        var nextC = c

        while (true) {
            nextR += dr[direction]
            nextC += dc[direction]

            if (nextR in 0 until map.size && nextC in 0 until map[nextR].size) {
                if (map[nextR][nextC] == 6) {
                    break
                } else {
                    map[nextR][nextC] = 7
                }
            } else {
                break
            }
        }
    }


    fun directionCount() = when(type) {
        1, 3, 4 -> 4
        2       -> 2
        else    -> 1
    }
}