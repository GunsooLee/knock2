import java.util.*
import kotlin.math.sqrt

fun main(args: Array<String>) {

    println(solution(437674, 3))
    println(solution(110011, 10))
}

var answer = 0
fun solution(n: Int, k: Int): Int {

    n.toString(k).split("0").filter { it != "" }.filter { it != "1" }.map { it.toInt() }.sorted().map { isPrime(it) }

    return answer
}

    fun isPrime(num: Int){
        var i = 2
        while(i*i <= num){
            if(num % i++ ==0 ){
                return
            }
        }
        answer++
    }