package com.virtualpairprogrammers.learningkotlin.kotlin

private fun printAString(value: String) =
    println(value)


fun addTwoNumbers(one: Double = 6.2, two: Double = 3.9) =
    one + two

fun printSomeMaths(one: Double, two: Double) {
    println ("one + two is ${one + two}")
    println ("one - two is ${one - two}")

    fun functionWithinAFunction(a : String) {
        println(a)
    }

    functionWithinAFunction("Hello")

}

fun methodTakesALambda(input: String, action: (String) -> Int ) {
    println(action(input))
}


fun main(args: Array<String>) {
    printAString("Hello world")
    println(addTwoNumbers(17.3, 9.6))
    println(addTwoNumbers(two = 5.6))
    printSomeMaths(two = 17.3, one = 9.6)

}