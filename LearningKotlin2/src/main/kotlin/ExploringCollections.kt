fun main(args: Array<String>) {
    val colors = listOf("Red", "Green", "Blue")

    println(colors::class.qualifiedName)

    val days = mutableListOf("Monday","Tuesday","Wednesday")
    val numbers = mutableListOf<Int>()

    val months = mutableSetOf("Jan","Feb")

    val webColors = mapOf("red" to "ff0000", "blue" to "00ff00")


    val intArray : IntArray = intArrayOf(1,2,3,4,5)
    intArray.set(3,-4)
    intArray[3] = -7
    intArray.forEach { println(it) }

    println(colors[2])
}