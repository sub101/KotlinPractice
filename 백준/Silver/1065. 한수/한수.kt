fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
 
    val num = br.readLine().toInt()
    var cnt = 0
 
    if(num < 100) {
        cnt = num
    } else {
        cnt = 99
        for(i in 100 .. num) {
            val h = i/100
            val t = (i/10)%10
            val o = i%10
 
            if(h - t == t - o) {
                cnt++
            }
        }
    }
 
    bw.write("$cnt")
    bw.flush()
    bw.close()
    br.close()
}