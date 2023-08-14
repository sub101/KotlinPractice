class Solution {
    fun solution(arr: Array<String>): String {
        var answer: String = ""
        for(i in 0 until arr.size){
            answer += arr[i]
        }
        return answer
    }
}