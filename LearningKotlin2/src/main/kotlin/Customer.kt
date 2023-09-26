data class Customer (val name: String, val address: String, var age: Int){
    constructor(name: String, age: Int) : this(name, "", age)
}

class AnotherAlternativeCustomer(val name: String, var age: Int, val address: String = "") {
    var approved: Boolean = false
        set(value) {
            if(age >= 21) {
                field = value
            } else {
                println("You can't approve a customer under 21 years old [${name}]")
            }
        }

    val nextAge
        get() = age + 1

    operator fun component1() = name
    operator fun component2() = age

    fun uppercaseName() = name.uppercase()

    override fun toString() = "$name is $address $age"

    companion object {
        fun getInstance() = AnotherAlternativeCustomer("Micky", 22, "Some address")
    }
}

fun main(args: Array<String>) {
    val customer = AnotherAlternativeCustomer("Aaron", 33, "21 Gamgol")
    customer.age = 16
    customer.approved = true
    val customer2 = AnotherAlternativeCustomer("James", 21)
    customer2.approved = true
    println("${customer.name} is ${customer.age} years old in ${customer.address} and is ${customer.approved}, next age is ${customer.nextAge}")
    println("${customer2.name} is ${customer2.age} years old in ${customer2.address} and is ${customer2.approved}, next age is ${customer2.nextAge}")
    println("next year ${customer.uppercaseName()} is ${customer.nextAge} years old")

    println(customer)

    val customer3 = AnotherAlternativeCustomer.getInstance()
    println(customer3)

    val customer4 = Customer("Sally", 29)// Data Class 는 toString(), hashCode(), equals(), copy() 메소드를 자동으로 만들어 준다.
    println(customer4)
    val customer5 = customer4.copy(name="Diane")// copy 시 원하는 값만 변경할 수 있다.
    println(customer5)

    /*
    val name = customer5.name
    val age = customer5.age
    -->?
     */

    var (name, age, address) = customer5

    println(address)

    var (name2, age2) = customer

    println(name2)
    println(age2)
}