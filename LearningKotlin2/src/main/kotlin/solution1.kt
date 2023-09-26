import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {


    println(Arrays.toString(solution(arrayOf("muzi", "frodo", "apeach", "neo"),arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"),2)))

}

fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    println(Arrays.toString(report.map{it.split(" ")}.groupBy { it[1] }.map{it.value.distinct()}.filter { it.size >= k }.flatten().map { it[0] }.groupingBy{it}.eachCount().run { id_list.map { getOrDefault(it, 0) }.toIntArray() }))
    report//[muzi frodo, apeach frodo, frodo neo, muzi neo, apeach muzi]
        .map{it.split(" ")}//[[muzi, frodo], [apeach, frodo], [frodo, neo], [muzi, neo], [apeach, muzi]]
        .groupBy { it[1] }//{frodo=[[muzi, frodo], [apeach, frodo]], neo=[[frodo, neo], [muzi, neo]], muzi=[[apeach, muzi]]}
        .map{it.value.distinct()}//[[[muzi, frodo], [apeach, frodo]], [[frodo, neo], [muzi, neo]], [[apeach, muzi]]]
        .filter { it.size >= k }//[[muzi, frodo], [apeach, frodo]], [[frodo, neo], [muzi, neo]]]
        .flatten()//[[muzi, frodo], [apeach, frodo], [frodo, neo], [muzi, neo]]
        .map { it[0] }//[muzi, apeach, frodo, muzi]
        .groupingBy{it}.eachCount()//{muzi=2, apeach=1, frodo=1}
        .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }


    val map = Array(id_list.size) {BooleanArray(id_list.size)}

    val users = HashMap<String, Int>()

    for (i in id_list.indices) {
        users[id_list[i]] = i
    }
    val sum = IntArray(id_list.size)

    var a: Int
    var b: Int
    for (i in report.indices) {
        val st = report[i].split(" ")
        a = users[st[0]]!!
        b = users[st[1]]!!
        if (!map[a][b]) {
            sum[b]++
            map[a][b] = true
        }
    }
    val answer = IntArray(id_list.size)
    for (i in map.indices) {
        if (sum[i] >= k) for (j in map.indices) {
            if (map[j][i]) answer[j]++
        }
    }
    return answer
}