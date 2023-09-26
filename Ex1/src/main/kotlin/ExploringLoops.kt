fun main(args: Array<String>) {

    val people = HashMap<Int, KotlinPerson>()
    people.put(1, KotlinPerson(1, "Mr", "James", "Apple", null))
    people.put(2, KotlinPerson(2, "Mrs", "Matt", "Orange", null))
    people.put(3, KotlinPerson(3, "Miss", "Aaron", "Eagles", null))
    people.put(4, KotlinPerson(4, "Mr", "Darren", "Chicken", null))

    for((key, value) in people){
        println("$value has key $key")
    }

    val myRange = 0..9
    for (i in myRange){
        println(i)
    }

    (0..9).forEach{println(it)}
    (9 downTo 0).forEach{println(it)}
    (0 until 9).forEach{println(it)}
    (0..9 step 2).forEach{println(it)}
    ('A'..'F').forEach{println(it)}

    
}