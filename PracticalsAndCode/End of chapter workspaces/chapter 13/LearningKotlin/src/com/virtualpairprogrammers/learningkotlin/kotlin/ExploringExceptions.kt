package com.virtualpairprogrammers.learningkotlin.kotlin

import java.io.FileInputStream

@Throws (InterruptedException::class)
fun divide(a: Int, b:Int) : Double {
    Thread.sleep(1000)
    return (a.toDouble()  / b)
}


fun printFile() {
    val input = FileInputStream("file.txt")

    input.use {
        //an exception could be thrown here
    }

}


fun main(args: Array<String>) {

    var result = try {
        divide(5,23)
    }
    catch (e: Exception) {
        println(e)
        0
    }

    println(result)

}