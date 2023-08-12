class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        var answer: String = ""
        var myStr = my_string.toCharArray()
        var overStr = overwrite_string.toCharArray()

        for (i in 0 until  overStr.size) {
            myStr[i+s] = overStr[i]
        }
        answer = myStr.joinToString("")
        return answer
    }
}