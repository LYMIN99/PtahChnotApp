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
        var number2 : TextView = itemView.findViewById(R.id.tv_number2)
        var number3 : TextView = itemView.findViewById(R.id.tv_number3)
        var number4 : TextView = itemView.findViewById(R.id.tv_number4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChnotDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chnot_item_detail, parent, false)
        return ChnotDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChnotDetailViewHolder, position: Int) {
        val chnotDetailItem = chnotDetailList[position]
        holder.post.text = chnotDetailItem.post
        holder.number2.text = chnotDetailItem.number2.toString()
        holder.number3.text = chnotDetailItem.number3.toString()
        holder.number4.text = chnotDetailItem.number4.toString()
    }

    override fun getItemCount(): Int {
        return chnotDetailList.size
    }
}
