class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var big = 0
        var small = 0 
        
        sizes.forEach{
           if(it[0] > it[1]){
               if(big < it[0]) big = it[0]
               if(small < it[1]) small = it[1]
           }else{
               if(big < it[1]) big = it[1]
               if(small < it[0]) small = it[0] 
           }
        }
              
        return big * small 
    }
}