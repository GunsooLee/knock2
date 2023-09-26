fun main(args: Array<String>) {
    val colors = listOf("Red", "Green", "Blue")

    println(colors::class.qualifiedName)

    val days = mutableListOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")

    val numbers = mutableListOf<Int>(1,2,3,4,5,6,7)

    val months = setOf("Jan", "Feb", "Mar", "Apr", "May")

    val webColors = mapOf("red" to "ff0000", "blue" to "00ff00")

    val intArray = arrayOf(1,2,3,4,5)

    println(intArray::class.qualifiedName)

    val intArray2: IntArray = intArrayOf(1,2,3,4,5)

    println(intArray2::class.qualifiedName)

    intArray2.set(3, -4)
    intArray2[3] = -7
    intArray2.forEach { println(it) }

    println(colors[2])


}