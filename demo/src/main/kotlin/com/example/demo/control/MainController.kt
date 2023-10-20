package com.example.demo.control

import com.example.demo.domain.Member
import com.example.demo.services.BookingService
import com.example.demo.services.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView
import com.example.demo.services.TheaterService
import org.apache.poi.POIDocument
import org.springframework.web.bind.annotation.RestController


@RestController
class MainController{
    @Autowired
    lateinit var theaterService: TheaterService
    /*
    Autowired 와 lateinit 는 짝궁
    늦은 초기화?
    lateinit를 적어주지 않으면 에러가 난다 -> 왜?
     */

    @Autowired
    lateinit var bookingService: BookingService


    @Autowired
    lateinit var testService: TestService

    @GetMapping("/test")
    fun getAllMembers() : List<Member> {
        return testService.getAllMembers()
    }

    @GetMapping("/insertMember")
    fun insertMember()  {
        testService.save(Member("이건수"))
    }

    @RequestMapping("helloWorld1")
    fun helloWorld1() : ModelAndView {
        return ModelAndView("helloWorld")
    }

    @RequestMapping("helloWorld3")
    fun helloWorld2() = ModelAndView("helloWorld")

    @RequestMapping("home")
    fun homePage() : ModelAndView =
        ModelAndView("seatBooking", "bean", CheckAvailabilityBackingBean())

    @RequestMapping("checkAvailability", method = arrayOf(RequestMethod.POST))
    fun checkAvailability(bean : CheckAvailabilityBackingBean) : ModelAndView {
        val selectedSeat = theaterService.find(bean.selectedSeatNum, bean.selectedSeatRow)
        val result = bookingService.isSeatFree(selectedSeat)

        bean.result = "Seat $selectedSeat is " + if (result) "available" else "booked"


        return ModelAndView("seatBooking", "bean", bean)
    }
}


class CheckAvailabilityBackingBean() {
    val seatNums = 1..36
    val seatRows = 'A'..'O'
    var selectedSeatNum: Int = 1
    var selectedSeatRow: Char = 'A'
    var result : String = ""
}


/*
REST API는 URL의 설계 방식

장점:
  URL만 보고도 무슨 행동을 하는 API인지 명확하게 알 수 있음

단점:
  GET, POST 등 방식의 제한
  설계를 하기 위해 공식적은 표준 규약이 없음

규칙 1. URL에는 동사를 쓰지 말고, 자원을 표시해야 한다.
  1. /students/1
  2. /get-student?student_id=1
  1번이 더 RESTful한 API이다

규칙 2. 동사는 HTTP 메서드로
  조회: GET /articles/1
  추가: POST /articles/1
  수정: PUT /articles/1
  삭제: DELETE /articles/1

 */