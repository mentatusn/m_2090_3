package com.gb.m_2090_3.view.recycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.ItemTouchHelper
import com.gb.m_2090_3.R
import com.gb.m_2090_3.databinding.ActivityMainBinding
import com.gb.m_2090_3.databinding.ActivityRecyclerBinding
import com.gb.m_2090_3.view.picture.PictureOfTheDayFragment

class RecyclerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityRecyclerBinding
    private val data = arrayListOf(
        Pair(Data(id=0,"Заголовок", type = TYPE_HEADER), false),
        Pair(Data(id=1,"Earth", type = TYPE_EARTH), false),
        Pair(Data(id=2,"Earth", type = TYPE_EARTH), false),
        Pair(Data(id=3,"Mars", type = TYPE_MARS), false),
        Pair(Data(id=4,"Earth", type = TYPE_EARTH), false),
        Pair(Data(id=5,"Earth", type = TYPE_EARTH), false),
        Pair(Data(id=6,"Earth", type = TYPE_EARTH), false),
        Pair(Data(id=7,"Mars", type = TYPE_MARS), false)
    )
    private var isNewList = false
    lateinit var adapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RecyclerAdapter(data, callbackAdd, callbackRemove)
        binding.recyclerView.adapter = adapter

        ItemTouchHelper(ItemTouchHelperCallback(adapter)).attachToRecyclerView(binding.recyclerView)

        binding.recyclerActivityDiffUtilFAB.setOnClickListener {
            changeAdapterData()
        }
    }

    private val callbackAdd = AddItem {
        data.add(it, Pair(Data(0,"Mars(New)", type = TYPE_MARS),false))
        adapter.setListDataAdd(data, it)
    }
    private val callbackRemove = RemoveItem {
        data.removeAt(it)
        adapter.setListDataRemove(data, it)
    }

    private fun changeAdapterData() {
        adapter.setListDataForDiffUtil(createItemList(isNewList).map { it }.toMutableList())
        isNewList = !isNewList
    }


    private fun createItemList(instanceNumber: Boolean): List<Pair<Data, Boolean>> {
        return when (instanceNumber) {
            false -> listOf(
                Pair(Data(0, "Header", type = TYPE_HEADER), false),
                Pair(Data(1, "Mars", ""), false),
                Pair(Data(2, "Mars", ""), false),
                Pair(Data(3, "Mars", ""), false),
                Pair(Data(4, "Mars", ""), false),
                Pair(Data(5, "Mars", ""), false),
                Pair(Data(6, "Mars", ""), false)
            )
            true -> listOf(
                Pair(Data(0, "Header",type = TYPE_HEADER), false),
                Pair(Data(1, "Mars", ""), false),
                Pair(Data(2, "Jupiter", ""), false),
                Pair(Data(3, "Mars", ""), false),
                Pair(Data(4, "Neptune", ""), false),
                Pair(Data(5, "Saturn", ""), false),
                Pair(Data(6, "Mars", ""), false)
            )
        }
    }

}