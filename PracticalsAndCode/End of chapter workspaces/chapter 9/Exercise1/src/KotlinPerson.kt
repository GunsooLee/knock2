import java.util.*

data class KotlinPerson (val id: Long,
                    val title: String,
                    val firstName: String,
                    val surname: String,
                    val dateOfBirth: Calendar?)

{

    var favoriteColor : String? = null


    fun getLastLetter(a : String) = a.takeLast(1)


    fun getUpperCaseColor() : String {
        return favoriteColor?.toUpperCase() ?: ""
    }

    fun getLastLetterOfColor() : String {
        return  favoriteColor?.let { getLastLetter(it) } ?: ""
    }


    fun getColorType() : String {
        val color = getUpperCaseColor()
        return when (color) {
            "" -> "empty"
            "RED", "GREEN", "BLUE" -> "rgb"
            else -> "other"
        }
    }

    override fun toString() =
        "$title $firstName $surname"

    val safeAge : Int
        get() = age ?: -1



    val age : Int?
        get() = getAge(dateOfBirth)

    companion object {
        fun getAge(dateOfBirth: Calendar?) : Int? {
            if (dateOfBirth == null) return null

            val today = GregorianCalendar()
            val years = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
            return if (dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.YEAR)) years -1 else years

        }
    }
}


fun main(args: Array<String>) {
    val john = KotlinPerson(1L, "Mr", "John", "Blue", GregorianCalendar(1977,9,3))
    val jane = KotlinPerson(2L, "Mrs", "Jane", "Green", null)
    println ("$john's age is ${john.age}")
    println ("$jane's age is ${jane.age}")
    println ("The age of someone born on 3rd May 1988 is " + KotlinPerson.getAge(GregorianCalendar(1988,5,3)));
    val olderPerson = if (john.safeAge > jane.safeAge) john else jane
    println("The older person was $olderPerson")
}