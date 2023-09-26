package com.lymin.ptahchnotmanager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lymin.ptahchnotmanager.model.ChnotDetailModel
import com.lymin.ptahchnotmanager.R

class ChnotDetailAdapter(private val chnotDetailList: List<ChnotDetailModel>) : RecyclerView.Adapter<ChnotDetailAdapter.ChnotDetailViewHolder>() {

    inner class ChnotDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var post : TextView = itemView.findViewById(R.id.tv_post)
        var number : TextView = itemView.findViewById(R.id.tv_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChnotDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chnot_item_detail, parent, false)
        return ChnotDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChnotDetailViewHolder, position: Int) {
        val chnotDetailItem = chnotDetailList[position]
        holder.post.text = chnotDetailItem.post
        holder.number.text = chnotDetailItem.number2.toString()
    }

    override fun getItemCount(): Int {
        return chnotDetailList.size
    }
}
