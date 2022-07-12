package com.gb.m_2090_3.view.recycler


const val TYPE_EARTH= 1
const val TYPE_MARS= 2
const val TYPE_HEADER= 3
data class Data(val id:Int =0 ,val name: String = "Text", val someDescription: String? = "Description", val type: Int =TYPE_MARS)