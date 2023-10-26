class Solution {
    fun solution(n: Int, control: String): Int {
        var answer: Int = 0
        var arr = control.split("")
        var num = n
        
        for(i in arr){
            if(i == "w") {
            num += 1
        }else if(i == "s") {
            num -= 1
        }else if(i == "d") {
            num += 10
        }else if(i == "a"){
            num -= 10
        }
        }
        answer = num
        return answer
    }
}