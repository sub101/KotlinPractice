class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        var string_a = a.toString()
        var string_b = b.toString()
        var string_sum = string_a + string_b
        var string_sum2 = string_b + string_a

        var sum = string_sum.toInt()
        var sum2 = string_sum2.toInt()

        if(sum2>sum) {
            answer = sum2
        }else{
            answer = sum
        }
        return answer
    }
}