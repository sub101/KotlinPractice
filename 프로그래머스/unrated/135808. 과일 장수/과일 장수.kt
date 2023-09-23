class Solution {
	fun solution(k: Int, m: Int, score: IntArray): Int {
		var answer: Int = 0
		score.sort()
		val maxBoxLength: Int = score.size / m
		var idx = 0
		var min = 10
        var i: Int = score.size - 1
		while (i >= m - 1) {
			for (j in i downTo i - m + 1) {
				min = Math.min(min, score.get(j))
			}
			answer += min * m
			i -= m
		}
        return answer
    }
}
