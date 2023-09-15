class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var (answer, painted) = 0 to 0
        for(each in section){
            if(each >= painted) {
                painted = m + each
                answer ++
            }
        }
        return answer
    }
}