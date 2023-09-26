package com.virtualpairprogrammers.learningkotlin.kotlin

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.fail

class AgeCalculation() {

    fun getAge(dob: Calendar) : Int {
        val today = Calendar.getInstance()
        if (dob.timeInMillis > today.timeInMillis) throw IllegalArgumentException()
        val years = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
        return if (dob.get(Calendar.DAY_OF_YEAR) > today.get(Calendar.DAY_OF_YEAR))
            years - 1
        else
            years
    }
}

class AgeCalculationTests() {

    val ageCalcClass = AgeCalculation()

    @Test
    fun checkAgeWhenBornToday() {
        assertEquals(0, ageCalcClass.getAge(Calendar.getInstance()))
    }

    @Test
    fun checkAgeWhenBorn1000DaysAgo() {
        val date = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, -1000)

        assertEquals(2, ageCalcClass.getAge(date))
    }

    @Test
    fun testforException() {
        val date = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, 10)

        Assertions.assertThrows(java.lang.IllegalArgumentException::class.java) {
            ageCalcClass.getAge(date)
        }

        
    }


}