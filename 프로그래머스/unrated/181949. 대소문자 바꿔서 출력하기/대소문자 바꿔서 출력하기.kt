fun main(args: Array<String>) {
    val s1 = readLine()!!

    val result = StringBuilder()

    for (char in s1) {
        if (char.isUpperCase()) {
            result.append(char.toLowerCase())
        } else if (char.isLowerCase()) {
            result.append(char.toUpperCase())
        } else {
            result.append(char)
        }
    }
    println(result)
}
