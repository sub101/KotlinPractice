class Solution {
    fun solution(num_list: IntArray): IntArray {
        var answer: IntArray = IntArray(num_list.size + 1)
        for (i in num_list.indices) { // 인덱스를 순회
            answer[i] = num_list[i]
        }
        if (num_list[num_list.size - 1] > num_list[num_list.size - 2]) {
            answer[num_list.size] = num_list[num_list.size - 1] - num_list[num_list.size - 2]
        } else {
            answer[num_list.size] = num_list[num_list.size - 1] * 2
        }
        return answer
    }
}
