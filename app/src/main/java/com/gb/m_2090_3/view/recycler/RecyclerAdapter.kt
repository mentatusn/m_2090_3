package com.gb.m_2090_3.view.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gb.m_2090_3.databinding.ActivityRecyclerItemEarthBinding
import com.gb.m_2090_3.databinding.ActivityRecyclerItemHeaderBinding
import com.gb.m_2090_3.databinding.ActivityRecyclerItemMarsBinding
import com.gb.m_2090_3.databinding.BottomNavigationLayoutBinding
import kotlinx.coroutines.NonDisposableHandle.parent

class RecyclerAdapter(private val listData: List<Data>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemViewType(position: Int): Int {
        return listData[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_EARTH -> {
                val binding =
                    ActivityRecyclerItemEarthBinding.inflate(LayoutInflater.from(parent.context))
                EarthViewHolder(binding)
            }
            TYPE_MARS -> {
                val binding =
                    ActivityRecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context))
                MarsViewHolder(binding)
            }
            else -> {
                val binding =
                    ActivityRecyclerItemHeaderBinding.inflate(LayoutInflater.from(parent.context))
                HeaderViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)){
            TYPE_EARTH -> {
                (holder as EarthViewHolder).bind(listData[position])
            }
            TYPE_MARS -> {
                (holder as MarsViewHolder).bind(listData[position])
            }
            else -> {
                (holder as HeaderViewHolder).bind(listData[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class HeaderViewHolder(val binding: ActivityRecyclerItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data:Data){
            binding.name.text = data.name
        }
    }

    class EarthViewHolder(val binding: ActivityRecyclerItemEarthBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data:Data){
            binding.name.text = data.name
        }
    }

    class MarsViewHolder(val binding: ActivityRecyclerItemMarsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data:Data){
            binding.name.text = data.name
        }
    }
}