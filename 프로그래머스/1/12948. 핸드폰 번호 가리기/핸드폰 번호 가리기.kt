class Solution {
    fun solution(phone_number: String): String {
        return phone_number.mapIndexed { index, c ->
            if (phone_number.length - 5 < index ) c else "*"
        }.joinToString(separator = "")
    }
}