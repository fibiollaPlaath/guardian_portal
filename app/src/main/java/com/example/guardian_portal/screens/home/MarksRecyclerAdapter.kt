package com.example.guardian_portal.screens.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.guardian_portal.databinding.LayoutItemMarksBinding
import com.example.guardian_portal.models.Marks

class MarksRecyclerAdapter(private val listener: (String) -> Unit) : RecyclerView.Adapter<MarksRecyclerAdapter.CustomViewHolder>() {

    private var markList = emptyList<Marks>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarksRecyclerAdapter.CustomViewHolder {
        return CustomViewHolder(
            LayoutItemMarksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MarksRecyclerAdapter.CustomViewHolder, position: Int) = holder.bind(
        markList[position] as Marks, listener)

    override fun getItemCount(): Int { return markList.size}

    inner class CustomViewHolder(private val binding: LayoutItemMarksBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(vendor: Marks, listener: (String) -> Unit) {

            binding.textViewMarks.text = vendor.AI.toString()
        }
    }

    fun populateRecyclerAdapter(allMarks: List<Marks>) {

        markList = allMarks
    }

}