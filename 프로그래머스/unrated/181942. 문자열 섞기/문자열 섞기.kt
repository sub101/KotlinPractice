class Solution {
    fun solution(str1: String, str2: String): String {
        var answer: String = ""
        var arrStr1 = str1.toCharArray()
        var arrStr2 = str2.toCharArray()

        for(i in 0 until arrStr1.size) {
            answer += arrStr1[i]
            answer += arrStr2[i]
        }
        return answer
    }
}