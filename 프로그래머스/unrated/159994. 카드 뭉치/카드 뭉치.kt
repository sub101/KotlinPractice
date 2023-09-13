class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var pointer1 = 0
        var pointer2 = 0
        var result = "Yes"

        goal.forEach {
            when (it) {
                cards1.getOrNull(pointer1) -> pointer1++
                cards2.getOrNull(pointer2) -> pointer2++
                else -> {
                    result = "No"
                    return@forEach
                }
            }
        }

        return result
    }
}