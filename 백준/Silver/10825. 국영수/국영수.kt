fun main() {
    val n = readLine()!!.toInt()
    val inputs = ArrayList<Info>(n)

    repeat(n) {
        val line = readLine()!!.split(" ")
        inputs.add(Info(line[0], line[1].toInt(), line[2].toInt(), line[3].toInt()))
    }
    inputs.sortedWith(compareBy({ -it.korean }, { it.english }, { -it.math }, { it.name })).forEach { println(it.name) }
}

data class Info(val name: String, val korean: Int, val english: Int, val math: Int)