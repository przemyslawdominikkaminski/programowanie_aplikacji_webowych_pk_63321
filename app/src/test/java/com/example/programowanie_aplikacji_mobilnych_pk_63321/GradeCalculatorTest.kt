package com.example.programowanie_aplikacji_mobilnych_pk_63321

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GradeCalculatorTest {

    private lateinit var calculator: GradeCalculator

    @Before
    fun setUp() {
        calculator = GradeCalculator()
    }

    // 1. Testy sprawdzające poszczególne progi ocen
    @Test
    fun `calculateGrade returns 2_0 for score below 50`() {
        val grade = calculator.calculateGrade(45)
        assertEquals("2.0", grade)
    }

    @Test
    fun `calculateGrade returns 3_0 for boundary score 50`() {
        val grade = calculator.calculateGrade(50)
        assertEquals("3.0", grade)
    }

    @Test
    fun `calculateGrade returns 5_0 for maximum score 100`() {
        val grade = calculator.calculateGrade(100)
        assertEquals("5.0", grade)
    }

    @Test
    fun `calculateGrade returns Nieznana for invalid score`() {
        val gradeBelowZero = calculator.calculateGrade(-5)
        val gradeAboveHundred = calculator.calculateGrade(105)

        assertEquals("Nieznana", gradeBelowZero)
        assertEquals("Nieznana", gradeAboveHundred)
    }

    // 2. Testy walidacji wejścia (null safety i zakresy)
    @Test
    fun `isValidScore returns true for valid score between 0 and 100`() {
        assertTrue(calculator.isValidScore(0))
        assertTrue(calculator.isValidScore(75))
        assertTrue(calculator.isValidScore(100))
    }

    @Test
    fun `isValidScore returns false for null or out of range score`() {
        assertFalse(calculator.isValidScore(null))
        assertFalse(calculator.isValidScore(-1))
        assertFalse(calculator.isValidScore(101))
    }
}