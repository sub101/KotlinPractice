class Solution {
    fun solution(age: Int): Int {
        var answer: Int = 0
        
        if(age<=22){
            answer = 2023 - age 
        } else {
            answer = 2000 - (age-23) 
        }
        return answer
    }
}