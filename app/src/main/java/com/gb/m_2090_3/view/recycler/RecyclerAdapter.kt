package com.gb.m_2090_3.view.recycler

import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.gb.m_2090_3.R
import com.gb.m_2090_3.databinding.ActivityRecyclerItemEarthBinding
import com.gb.m_2090_3.databinding.ActivityRecyclerItemHeaderBinding
import com.gb.m_2090_3.databinding.ActivityRecyclerItemMarsBinding

class RecyclerAdapter(private var listData: MutableList<Pair<Data,Boolean>>,val callbackAdd: AddItem,val callbackRemove: RemoveItem) :
    RecyclerView.Adapter<RecyclerAdapter.BaseViewHolder>(),ItemTouchHelperAdapter {


    fun setListDataRemove(listDataNew: MutableList<Pair<Data,Boolean>>,position: Int){
        listData = listDataNew
        notifyItemRemoved(position)
    }

    fun setListDataAdd(listDataNew: MutableList<Pair<Data,Boolean>>,position: Int){
        listData = listDataNew
        notifyItemInserted(position)
    }

    override fun getItemViewType(position: Int): Int {
        return listData[position].first.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
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

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }





    inner class MarsViewHolder(val binding: ActivityRecyclerItemMarsBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Pair<Data,Boolean>) {
            binding.name.text = data.first.name
            binding.addItemImageView.setOnClickListener {
                callbackAdd.add(layoutPosition)
            }
            binding.removeItemImageView.setOnClickListener {
                callbackRemove.remove(layoutPosition)
            }

            binding.moveItemUp.setOnClickListener {
                // TODO HW java.lang.IndexOutOfBoundsException: Index: -1, Size: 7
                listData.removeAt(layoutPosition).apply {
                    listData.add(layoutPosition-1,this)
                }
                notifyItemMoved(layoutPosition,layoutPosition-1)
            }

            binding.moveItemDown.setOnClickListener {
                // TODO HW java.lang.IndexOutOfBoundsException: Index: 8, Size: 7
                listData.removeAt(layoutPosition).apply {
                    listData.add(layoutPosition+1,this)
                }
                notifyItemMoved(layoutPosition,layoutPosition+1)
            }
            binding.marsDescriptionTextView.visibility = if(listData[layoutPosition].second) View.VISIBLE else View.GONE

            binding.marsImageView.setOnClickListener {
                listData[layoutPosition] = listData[layoutPosition].let {
                    it.first to !it.second
                }
                notifyItemChanged(layoutPosition)
            }

        }


    }





    class EarthViewHolder(val binding: ActivityRecyclerItemEarthBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Pair<Data,Boolean>) {
            binding.name.text = data.first.name
        }
    }

    class HeaderViewHolder(val binding: ActivityRecyclerItemHeaderBinding) :
        BaseViewHolder(binding.root) {
        override fun bind(data: Pair<Data,Boolean>) {
            binding.name.text = data.first.name
        }
    }

    abstract class BaseViewHolder(view: View) :
        RecyclerView.ViewHolder(view),ItemTouchHelperViewHolder {
        abstract fun bind(data: Pair<Data,Boolean>)
        override fun onItemSelect() {
            itemView.setBackgroundColor(ContextCompat.getColor(itemView.context,R.color.my_color))
        }

        override fun onItemClear() {
            itemView.setBackgroundColor(0)
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        listData.removeAt(fromPosition).apply {
            listData.add(toPosition,this)
        }
        notifyItemMoved(fromPosition,toPosition)
    }

    override fun onItemDismiss(position: Int) {
        callbackRemove.remove(position)
    }
}