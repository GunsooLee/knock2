package com.example.demo.services

import com.example.demo.domain.Seat
import org.springframework.stereotype.Service

@Service
class BookingService {
    fun isSeatFree(seat : Seat) : Boolean {
        return true
    }
}