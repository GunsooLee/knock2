package com.virtualpairprogrammers.learningkotlin.kotlin

fun main(args: Array<String>) {
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