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
    private val data = arrayListOf(
        Data("Заголовок",type= TYPE_HEADER),
        Data("Earth",type=TYPE_EARTH),
        Data("Earth",type=TYPE_EARTH),
        Data("Mars", type= TYPE_MARS),
        Data("Earth",type=TYPE_EARTH),
        Data("Earth",type=TYPE_EARTH),
        Data("Earth",type=TYPE_EARTH),
        Data("Mars", type=TYPE_MARS)
    )
    lateinit var adapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter=  RecyclerAdapter(data,callbackAdd,callbackRemove)
        binding.recyclerView.adapter =adapter


    }
    private val callbackAdd = AddItem {
        data.add(it, Data("Mars(New)", type= TYPE_MARS))
        adapter.setListDataAdd(data,it)
    }
    private val callbackRemove = RemoveItem {
        data.removeAt(it)
        adapter.setListDataRemove(data,it)
    }
}