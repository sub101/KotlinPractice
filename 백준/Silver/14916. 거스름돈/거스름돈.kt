private var n = 0
private var result = 0
fun main() {
    val br = System.`in`.bufferedReader()
    n = br.readLine().toInt()
    while(n > 0 ){
        if(n%5 == 0){
            result += n /5
            break
        }
        else {
            n -= 2
            result += 1
        }
    }
    println(if(n>=0) result else -1)
}