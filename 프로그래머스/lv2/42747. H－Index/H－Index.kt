class Solution {
    fun solution(citations: IntArray): Int =
        citations.sortedDescending().filterIndexed { index, i -> (index + 1) <= i }.lastIndex + 1
}