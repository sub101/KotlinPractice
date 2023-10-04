class Solution {
    fun solution(new_id: String): String {
         val new = new_id.lowercase()
        .replace("[^a-z0-9_.-]".toRegex(),"")
        .replace("[.]{2,}".toRegex(), ".")
        .replace("^[.]|$[.]".toRegex(),"")
        .let { it.ifEmpty { "a" } }
        .let { if(it.length>15) it.slice(0..14) else it }
        .replace("[.]$".toRegex(),"")
        .let { s -> var str = s
            if(s.length<3) { repeat(3-s.length) { str = str.plus(s.last()) } }
            str
        }
        
        return new
    }
}
