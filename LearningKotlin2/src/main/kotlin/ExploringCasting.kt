import java.math.BigDecimal
import java.util.*

fun main(args: Array<String>) {

    var result: Any

    val randomNumber = Random().nextInt(3)

    if(randomNumber == 1){
        result = BigDecimal(30)
    } else {
        result = "hello"
    }
    println("Result is currently $result")

    if( result is BigDecimal){
        //add 47
        result = result.add(BigDecimal(47))
    } else {
        //put in into uppercase
        val tempResult = result as String
        result = tempResult.uppercase()
    }

    println("Result is currently $result")
}