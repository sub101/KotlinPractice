class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()

        for (command in commands){
            var n = command[0]
            var m = command[1]
            var subarray = mutableListOf<Int>()


            for (i in n-1..m-1){
                subarray.add(array[i])
            }

            subarray.sort()
            answer.add(subarray[command[2]-1])
        }
        return answer.toIntArray()
    }
}