class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var minX = Int.MAX_VALUE
        var minY = Int.MAX_VALUE
        var maxY = Int.MIN_VALUE
        var maxX = Int.MIN_VALUE
        for (r in wallpaper.indices) {
            val line = wallpaper[r]
            line.toCharArray().forEachIndexed { idx, block ->
                if (block == '#') {
                    minX = minX.coerceAtMost(idx)
                    minY = minY.coerceAtMost(r)
                    maxX = maxX.coerceAtLeast(idx)
                    maxY = maxY.coerceAtLeast(r)
                }
            }
        }
        return intArrayOf(minY, minX, maxY + 1, maxX + 1)
    }
}