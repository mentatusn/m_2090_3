package com.gb.m_2090_3.view.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.gb.m_2090_3.R
import com.gb.m_2090_3.databinding.ActivityMainBinding
import com.gb.m_2090_3.databinding.ActivityRecyclerBinding
import com.gb.m_2090_3.view.picture.PictureOfTheDayFragment

class RecyclerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = arrayListOf(
            Data("Заголовок",type= TYPE_HEADER),
            Data("Earth",type=TYPE_EARTH),
            Data("Earth",type=TYPE_EARTH),
            Data("Mars", type= TYPE_MARS),
            Data("Earth",type=TYPE_EARTH),
            Data("Earth",type=TYPE_EARTH),
            Data("Earth",type=TYPE_EARTH),
            Data("Mars", type=TYPE_MARS)
        )
        binding.recyclerView.adapter = RecyclerAdapter(data)


    }
}