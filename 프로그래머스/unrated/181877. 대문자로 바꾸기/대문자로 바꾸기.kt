class Solution {
    fun solution(myString: String): String {
        var answer: String = ""
        
        for(char in myString){
            answer += char.toUpperCase()
        }
        return answer
    }
}