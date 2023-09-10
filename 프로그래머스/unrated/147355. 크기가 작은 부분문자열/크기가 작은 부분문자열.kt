class Solution {
    fun solution(t: String, p: String): Int {
        var answer: Int = 0

        for (i in 0 until t.length - p.length + 1) {
            val sub = t.substring(i, i + p.length)

            // Int 비교가 아니라 Long 비교
            if (sub.toLong() <= p.toLong()) {
                answer++
            }
        }

        return answer
    }
}