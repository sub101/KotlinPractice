class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        var answer: Int = 0
        var temp : Boolean
        
        if(ineq == ">"){
            if(eq == "="){
                temp = n>=m
            }else {
                temp = n>m
            }
        }else {
            if(eq == "="){
                temp = n<=m
            }else {
                temp = n<m
            }
        }
        if(temp == true) answer = 1
        else answer = 0
        
        return answer
    }
}