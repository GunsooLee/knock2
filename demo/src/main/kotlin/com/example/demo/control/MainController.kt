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

    @Autowired
    lateinit var bookingService: BookingService


    @Autowired
    lateinit var testService: TestService

    @GetMapping("/test")
    fun getAllMembers() : List<Member> {
        return testService.getAllMembers()
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