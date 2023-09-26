fun main(args: Array<String>) {

//    var x : Int = 0
//
//    while (x < 10) {
//        println(x)
//        x++
//    }



    for (i in 0..9) {
        println(i)
    }

    (0..9).forEach { println(it) }
    (9 downTo 0).forEach { println(it) }
    (0 until 9).forEach {println(it)}
    (0..9 step 2).forEach {println(it)}
    ('A'..'F').forEach {println(it)}
}