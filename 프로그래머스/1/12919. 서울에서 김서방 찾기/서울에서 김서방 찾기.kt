class Solution {
    fun solution(seoul: Array<String>): String {
        seoul.forEachIndexed { index, value ->
            if(value == "Kim") return "김서방은 ${index}에 있다"
        }
        return ""
    }
}