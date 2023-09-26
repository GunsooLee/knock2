


fun printAString(value: String) :Unit{
    println(value)
}

fun addTowNumbers(one: Double, two: Double): Double {
    return one + two
}

fun addTowNumbersSingleLine(one: Double, two: Double): Double = one + two

fun printSomeMaths(one: Double, two: Double){
    //one = 2.5 function안에서는 val로 선언되고 값 변경 불가
    // Parameters는 Immutablegkek
    println("one + two is ${one + two}")
    println("one - two is ${one - two}")

    fun functionWithinAFunction(a: String){
        println(a)
    }

    functionWithinAFunction("Hello")
}

fun addTowNumbersWithDefault(one: Double = 6.2, two: Double = 3.9): Double = one + two

fun methodTakesALambda1(input: String, action: java.util.function.Function<String, Int>){
    println(action.apply(input))
}

fun methodTakesALambda2(input: String, action: (String) -> Int){
    println(action(input))
}

fun main(args: Array<String>) {
    printAString("abciiii")
    println(addTowNumbersSingleLine(3.5 ,23.5))
    printSomeMaths(12.3, 9.6)
    printSomeMaths(two = 12.3, one = 9.6)
    println(addTowNumbersWithDefault())
    println(addTowNumbersWithDefault(5.31))
}