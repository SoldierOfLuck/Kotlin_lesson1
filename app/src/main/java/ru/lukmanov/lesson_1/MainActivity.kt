package ru.lukmanov.lesson_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val w = Weather("Москва", -17)
        val Text1 : TextView = findViewById(R.id.feature1)
        val Text2 : TextView = findViewById(R.id.feature2)
        val Text3 : TextView = findViewById(R.id.ObjectCopy)
        val Text4 : TextView = findViewById(R.id.Cycle1)
        val Text5 : TextView = findViewById(R.id.Cycle2)
        val Text6 : TextView = findViewById(R.id.Cycle3)
        val Button1 : Button = findViewById(R.id.button1)
        var weatherList : List<Weather> = listOf(Weather("Краснодар", 15), Weather("Уфа", -25),
            Weather("Казань", -15))
        Button1.setOnClickListener{
            Text1.text = w.town
            Text2.text = w.temperature.toString()
            Text3.text = Weather.copy(town = "Санкт-Петербург") as String
            for (weather in weatherList) {
                Text4.text = weather.town+"   "+weather.temperature.toString()
                println(weather)
            }
            for (i in 0..2){
                Text5.text = weatherList[0].town+"   "+weatherList[0].temperature.toString()
                Text6.text = weatherList[1].town+"   "+weatherList[1].temperature.toString()
                println(weatherList[i])
            }
        }
    }


    data class Weather(val town: String = "", val temperature: Int = 0){
        companion object Object{
            fun copy(town: String): Any {
                return town
            }
        }

    }
}