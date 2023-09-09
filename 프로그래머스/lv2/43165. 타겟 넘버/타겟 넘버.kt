class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        var n = numbers.size

        fun dfs(index: Int, result: Int) {
            if (index == n) {
                if (result == target) {
                    answer += 1
                }
            } else {
                dfs(index + 1, result + numbers[index])
                dfs(index + 1, result - numbers[index])
            }
        }

        dfs(0, 0)
        return answer
    }
}