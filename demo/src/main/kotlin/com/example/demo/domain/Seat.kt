package com.example.demo.domain

import jakarta.persistence.GeneratedValue
import org.springframework.data.annotation.Id
import java.math.BigDecimal

data class Seat(
    val row: Char,
    val num: Int,
    val price: BigDecimal,
    val description: String) {
    override fun toString(): String = "Seat $row-$num $$price ($description)"
}
