package com.virtualpairprogrammers.learningkotlin.kotlin

import java.math.BigDecimal
import kotlin.math.roundToInt

fun main(args: Array<String>) {

    val myDouble = 21.4

    println("Is myDouble a Double? ${myDouble is Double}")
    println("myDouble is a ${myDouble::class.qualifiedName}")

    println("myDouble's javaClass is ${myDouble.javaClass}")


    val myInteger = myDouble.roundToInt()
    println("myInteger is a ${myInteger::class.qualifiedName}")

    val anotherInteger : Int = 17

    val myFloat : Float = 13.6f

    val result = myFloat + anotherInteger
    println(result)

    val bd = BigDecimal(17)

    val bd2 : BigDecimal

    println("hello")

    bd2 = bd.add(BigDecimal(30))


    var name = "Matt"
    val surname = "Greencroft"

    name = "John"

    println ("Hello $name ${surname.toUpperCase()}")
    println("The \$name variable has ${name.length} characters")
    println("Your product cost \$about10")


    val story = """It was a dark and stormy night.
        |A foul smell crept across the city.
        |Jane wondered what time it was, and when it would be daylight.""".trimMargin("|")

    println(story)

    val changedStory = story.replaceAfterLast("it", " would be dawn.")

    println(changedStory)
}