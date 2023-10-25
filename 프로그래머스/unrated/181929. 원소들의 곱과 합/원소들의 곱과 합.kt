class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        var add : Int = 0
        var gob : Int = 1
        
        for(i in num_list){
            add += i
        }
        for(i in num_list){
            gob *= i
        }
        
        if(add*add > gob){
            answer = 1
        } else {
            answer = 0
        }
        return answer
    }
}