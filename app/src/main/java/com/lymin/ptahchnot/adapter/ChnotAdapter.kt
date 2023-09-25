package com.lymin.ptahchnot.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lymin.ptahchnot.model.ChnotModel
import com.lymin.ptahchnot.R

class ChnotAdapter(private val chnotList: List<ChnotModel>) : RecyclerView.Adapter<ChnotAdapter.ChnotViewHolder>() {

    inner class ChnotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var innerRecyclerView : RecyclerView = itemView.findViewById(R.id.innerRecyclerView)
        var dateTime : TextView = itemView.findViewById(R.id.tv_date_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChnotViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chnot_item, parent, false)
        return ChnotViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChnotViewHolder, position: Int) {
        val chnotItem = chnotList[position]

        holder.dateTime.text = "ថ្ងៃ ${chnotItem.date} ម៉ោង ${chnotItem.time}"
        val innerAdapter = ChnotDetailAdapter(chnotItem.details)
        holder.innerRecyclerView.adapter = innerAdapter
    }

    override fun getItemCount(): Int {
        return chnotList.size
    }
}
