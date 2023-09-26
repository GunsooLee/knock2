fun main(args: Array<String>) {

    //var name: String = null//기본적으로 null 불가
    var name: String? = null//type뒤에 ?를 붙이면 nullable

    //name = "Matt"
    println("$name".uppercase())//NULL
    println(name?.uppercase())// name이 null이 아니면 uppercase, null이면 그냥 null(uppercase를 안해서 오류x)
    //println(name!!.uppercase())// 강제로 null이 아님을 설정해서 not null로 인식. 이렇게 해놓고 null을 넣으면 NPE발생


    /*
    var address = null//var null로 생성 시 nothing? 타입으로 생성되고

    address = "Hello"// 타입 변경 불가
    */

    var address: String? = null

    address = "Hello"

    var myInteger: Int? = 7

    myInteger = null


    /*
    Any는 java의 Object 모든 객체의 조상

    Unit은 java의 void와 비슷.
    Unit과 void의 차이점
    Unit은 싱글톤 인스턴스: 객체. Any의 자식이 됨

    */
    var myUnit: Unit

    printAString("call Function")
}