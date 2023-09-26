class Solution {
    fun solution(food: IntArray): String {
        var answer: String = ""
        val foodCnt = food.slice(1..food.size-1).map{ it/2 }
        val individualFood = mutableListOf<Int>()
        for(i in foodCnt.indices){
            for(j in 0 until foodCnt[i]) {
                if(foodCnt[i]!=0) {
                    individualFood.add(i+1)
                } 
            } 
        }
        answer = individualFood.joinToString("") + "0" + individualFood.reversed().joinToString("")
        return answer
    }
}