class Solution {
    fun solution(num_list: IntArray, n: Int): Int {
        var answer: Int = 0
        
        for(i in num_list.indices) {
            if( num_list[i] == n) answer = 1
            else continue
        }
        return answer
    }
}