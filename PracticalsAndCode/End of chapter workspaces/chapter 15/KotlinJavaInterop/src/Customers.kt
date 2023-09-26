data class Customer (val id: Long, val name: String)

class CustomerDatabase() {
    val customers = listOf(Customer(1, "Matt"),
            Customer(2, "James"),
            Customer(3, "Dianne"),
            Customer(4, "Sally"))

    @Throws(IllegalAccessException::class)
    fun addCustomer(c : Customer) {
        throw IllegalAccessException("You cannot add a customer")
    }

    companion object {
        @JvmStatic
        fun helloWorld() =
            println("Hello world")

    }

}