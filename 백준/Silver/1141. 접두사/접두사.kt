import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

fun main(){

    var scanner = Scanner(System.`in`)


    var N = scanner.nextInt()
    var answer = 0

    var list = ArrayList<String>()

    for(i in 0 until N){

        list.add(scanner.next())
    }

    list.sortBy { it.length }

    for(i in list.indices){

        var check = true
        for(j in i+1 until list.size){

            if(list[j].startsWith(list[i])){
                check = false
                break
            }
        }

        if(check){
            answer++
        }
    }

    println(answer)
}