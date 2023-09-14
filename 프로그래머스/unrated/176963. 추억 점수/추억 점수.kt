class Solution {
     fun solution(names: Array<String>, yearnings: IntArray, photoes: Array<Array<String>>): IntArray {
        val map = names.zip(yearnings.toTypedArray()).toMap()
        return photoes.map { photo -> photo.sumOf { map[it] ?: 0 } }.toIntArray()
    }
}