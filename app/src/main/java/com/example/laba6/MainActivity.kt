package com.example.laba6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.laba6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val rounds = mutableListOf<Round>()
    private var currentRound = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvQuestion.text = "Тут будет первый вопрос"
        fillRounds()
        updateUI()
        binding.button1.setOnClickListener{
            processRound(1)
        }
        binding.button2.setOnClickListener{
            processRound(2)
        }
        binding.button3.setOnClickListener{
            processRound(3)
        }
        binding.button4.setOnClickListener{
            processRound(4)
        }
    }
    private fun fillRounds(){
        rounds.run{
            add(Round("Что такое C#?","Система управления базами данных","Архитектурный шаблон", "Язык программирования", "Графический редактор",3,100))
            add(Round("Как объявить переменную в C#?","var myVariable = 10;","myVariable = 10;", "int myVariable = 10;", " myVariable int = 10;",3,1000))
            add(Round("Что такое класс в C#?","Набор функций","Набор данных", "Атрибут", "Интерфейс",1,10000))
            add(Round("Как создать массив в C#?","int [] myArray = {1, 2, 3};","myArray<int> = (1, 2, 3);", "myArray = {1, 2, 3};", "array myArray = {1, 2, 3};",1,100000))
            add(Round("Что такое условный оператор IF в C#?","Оператор цикла","Оператор простого ветвления", "Оператор выбора", "Оператор присваивания",2,1000000))
        }
    }
    private fun updateUI(){
        binding.tvQuestion.text = rounds[currentRound].question
        binding.tvValue.text = rounds[currentRound].value.toString()
        binding.button1.text = rounds[currentRound].answer1
        binding.button2.text = rounds[currentRound].answer2
        binding.button3.text = rounds[currentRound].answer3
        binding.button4.text = rounds[currentRound].answer4
    }
    private fun checkAnswer(givenId: Int) = (givenId == rounds[currentRound].rightId)
    private fun goNextRound(): Boolean{
        if(currentRound>=rounds.size - 1) return false
        currentRound++
        updateUI()
        return true
    }
    private fun processRound(givenId: Int){
        if(checkAnswer(givenId)){
            if(!goNextRound()){
                Toast.makeText(this, "YOU WIN :)", Toast.LENGTH_SHORT).show()
                finish()
            }
        } else{
            Toast.makeText(this, "YOU LOOSE :(", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}