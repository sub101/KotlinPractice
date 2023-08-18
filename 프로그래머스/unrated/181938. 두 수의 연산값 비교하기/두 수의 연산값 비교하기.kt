class Solution {
    fun solution(a: Int, b: Int): Int {
        
        var answer: Int = 0
        var string_a = a.toString()
        var string_b = b.toString()
        var string_sum = string_a + string_b

        var sum = string_sum.toInt()

        if(sum >= 2*a*b) {
            answer = sum
        }else {
            answer = 2*a*b
        }
        
        return answer
    }
}