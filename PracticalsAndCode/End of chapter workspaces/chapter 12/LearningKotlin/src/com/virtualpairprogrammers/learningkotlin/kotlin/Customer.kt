package com.virtualpairprogrammers.learningkotlin.kotlin

data class Customer (val name : String,
                val address: String,
                var age: Int)  {

    constructor(name: String, age: Int) : this(name, "", age)
}


class AlternativeCustomer (val name: String, var age: Int) {
    var address: String

    init {
        address = ""
    }

    constructor(name: String, address: String, age: Int) : this(name, age) {
        this.address = address
    }
}

class AnotherAlternativeCustomer (val name: String, var age: Int, val address : String = "") {

    var approved: Boolean = false
    set(value) {
        if (age >= 21) {
            field = value
        }
        else {
            println("You can't approve a customer under 21 years old.")
        }
    }

    val nextAge
    get() = age + 1


    operator fun component1() = name
    operator fun component2() = age



    fun uppercaseName() =
        name.toUpperCase()

    override fun toString() =
        "$name $address $age"

    companion object {
        fun getInstance() = AnotherAlternativeCustomer("Micky", 22, "Some address")
    }

}


fun main(args: Array<String>) {
    val customer = AnotherAlternativeCustomer("Matt",21, "10 The High Road")
    customer.age = 19
    customer.approved = true
    val customer2 = AnotherAlternativeCustomer("John",31)
    customer2.approved = true
    println("${customer} is ${customer.age} years old and is ${customer.approved}")
    println("${customer2.name} is ${customer2.age} years old and is ${customer2.approved}")
    println("next year ${customer.uppercaseName()} will be ${customer.nextAge}")

    val customer3 = AnotherAlternativeCustomer.getInstance()
    println(customer3)



    val customer4 = Customer("Sally", 29)
    println(customer4)
    val customer5 = customer4.copy(name="Diane")
    println(customer5)

    val (name, address, age) = customer5
    val (name2, age2) = customer

}

