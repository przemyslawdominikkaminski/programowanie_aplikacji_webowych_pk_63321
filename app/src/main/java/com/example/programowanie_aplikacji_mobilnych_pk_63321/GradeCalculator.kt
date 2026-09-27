package com.example.programowanie_aplikacji_mobilnych_pk_63321

class GradeCalculator {
    fun calculateGrade(points: Int?): String {
        if (points==null) {
            return "Brak inputu"
        }
        return when {
            points < 0 -> "Nieznana"
            points < 50 -> "2.0"
            points in 50..60 -> "3.0"
            points in 61..70 -> "3.5"
            points in 71..80 -> "4.0"
            points in 81..90 -> "4.5"
            points in 91..100 -> "5.0"
            else -> "Nieznana"
        }
    }

    fun isValidScore(points: Int?): Boolean {
        return points !=null && (points in 0..100)
    }
}