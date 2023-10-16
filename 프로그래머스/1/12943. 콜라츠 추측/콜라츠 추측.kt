class Solution {
    fun solution(num: Int): Int {
        var n = num.toLong()
        var cnt = 0
        while(n != 1L && cnt < 500){
            if(n % 2 == 0L) n /= 2
            else n = n * 3 + 1
            println(n)
            cnt++
        }
        return if(cnt == 500) -1 else cnt
    }
}