package com.example.programowanie_aplikacji_mobilnych_pk_63321

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var calculator: GradeCalculator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        calculator = GradeCalculator()

        val imieTextArea = findViewById<EditText>(R.id.imieTextArea)
        val nazwiskoTextArea = findViewById<EditText>(R.id.nazwiskoTextArea)
        val wynikNumberInput = findViewById<EditText>(R.id.wynikNumberInput)
        val obliczButton = findViewById<Button>(R.id.obliczButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        obliczButton.setOnClickListener {
            val student = Student(
                imie = imieTextArea.text.toString().trim(),
                nazwisko = nazwiskoTextArea.text.toString().trim(),
                punkty = wynikNumberInput.text.toString().toIntOrNull()
            )
            val bladKolor = android.graphics.Color.parseColor("#FFCDD2")
            val okKolor = android.graphics.Color.parseColor("#C8E6C9")
            when {
                student.imie.isEmpty() -> {
                    resultTextView.text = "Podaj imie"
                    resultTextView.setBackgroundColor(bladKolor)
                }
                student.nazwisko.isEmpty() -> {
                    resultTextView.text = "Podaj nazwisko"
                    resultTextView.setBackgroundColor(bladKolor)
                }
                !calculator.isValidScore(student.punkty) -> {
                    resultTextView.text = "Podaj liczbe punktów od 0 do 100"
                    resultTextView.setBackgroundColor(bladKolor)
                }
                else -> {
                    val grade = calculator.calculateGrade(student.punkty)
                    resultTextView.text = "Student: ${student.imie} ${student.nazwisko}\n" +
                            "Punkty: ${student.punkty}\n" +
                            "Ocena: $grade"
                    resultTextView.setBackgroundColor(okKolor)
                }
            }
            resultTextView.visibility = android.view.View.VISIBLE
        }
    }
}