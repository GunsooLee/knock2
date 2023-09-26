import java.util.*
import kotlin.math.sqrt

fun main(args: Array<String>) {

    setPrimes(232L)
    //println(solution(437674, 3))
    //println(solution(110011, 10))
    println(primes)
}

var answer = 0
fun solution(n: Int, k: Int): Int {

    val sorted = n.toString(k).split("0").filter { it != "" }.map { it.toLong() }.sorted().filter { it > 1 }

    val primes: BooleanArray = BooleanArray(sqrt(sorted[sorted.size-1].toDouble()).toInt(), true);
    setPrimes(sorted[sorted.size-1])

    var sn = 0
    var pn = 0
        while(sn < sorted.size && pn < primes.size){
            if(sorted[sn] == primes[pn]) {
                answer++
                sn++
            } else if (sorted[sn] > primes[pn]){
                pn++
            } else if (sorted[sn] < primes[pn]){
                sn++
            }
        }

    return answer
}

    fun setPrimes(max: Long){
        for (n in 3..max){
            for (p in primes){
                if(n%p == 0L) break
                if(p*p > n){
                    primes.add(n)
                    break
                }
            }
        }
    }