package com.example.myapplication.hlpers

import com.example.myapplication.R

class CityDataSource {
    fun loadCities(): List<City> {
        return listOf<City>(
            City(1, R.string.hi, R.drawable.ic_launcher_foreground),
            City(2, R.string.hello, R.drawable.img),
            City(3, R.string.there, R.drawable.img_1),
            City(4, R.string.by, R.drawable.img_2)


        )
    }
}