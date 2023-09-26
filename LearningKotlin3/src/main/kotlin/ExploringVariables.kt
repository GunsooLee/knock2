import java.math.BigDecimal
import kotlin.math.roundToInt

fun main(args: Array<String>) {

    var myDouble = 21.4
    println("Is myDouble a Double? ${myDouble is Double}")
    println("myDouble is a ${myDouble::class.qualifiedName}")

    println("myDouble's javaClass is ${myDouble.javaClass}")
    println("myDouble to int ${myDouble.roundToInt()}")

    val myInteger = myDouble.roundToInt()
    println("myInteger is a ${myInteger::class.qualifiedName}")

    val anotherInteger: Int = 17

    val myFloat: Float = 13.6f

    val result = myFloat + anotherInteger
    println(result)

    //java코드
    //BigDecimal bd = new BigDecimal(17);
    //Kotlin코드
    //val bd: BigDecimal = BigDecimal(17)
    val bd = BigDecimal(17)

    val bd2: BigDecimal
    bd2 = bd.add(BigDecimal(30))

    var name = "Matt"
    val surname = "Greencroft"

    name = "John"
    println("Hello $name ${surname.uppercase()}")
    println("Your first name has ${name.length} characters")
    println("Tour product cost \$about10")

    val story = """
        동해물과 백두산이 마르고 닳도록
        하느님이 보우하사 우리나라 만세
        무궁화 삼천리 화려강산
        대한사람 대한으로 길이 보전하세
    """.trimIndent()

    println(story)

    val changedStory = story.replaceAfterLast("대한", "금수강산")

    println(changedStory)
}