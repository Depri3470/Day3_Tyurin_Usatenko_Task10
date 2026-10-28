package com.depri.day3_tyurin_usatenko_task10

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userNameEdit = findViewById<EditText>(R.id.userNameEdit)
        val userAgeEdit = findViewById<EditText>(R.id.userAgeEdit)
        val btnSend = findViewById<Button>(R.id.button)
        var userSex = ""

        val radioGroupSex = findViewById<RadioGroup>(R.id.radioGroup)

        val userNameOut = findViewById<TextView>(R.id.userName)
        val userAgeOut = findViewById<TextView>(R.id.userAge)
        val userSexOut = findViewById<TextView>(R.id.userSex)

        radioGroupSex.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rdMale -> userSex = "Мужской"
                R.id.rdFemale -> userSex = "Женский"
            }
        }

        btnSend.setOnClickListener {
            val userName = userNameEdit.text.toString().trim()
            val userAge = userAgeEdit.text.toString().trim()

            if (userName.isNotEmpty() and userAge.isNotEmpty() and userSex.isNotEmpty()) {
                userNameOut.text = "Ваше имя: ${userName}"
                userAgeOut.text = "Ваш возраст: ${userAge}"
                userSexOut.text = "Ваш пол: ${userSex}"
            } else {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }
    }
}