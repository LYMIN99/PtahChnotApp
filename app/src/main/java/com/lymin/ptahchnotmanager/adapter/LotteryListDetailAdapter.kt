package com.lymin.ptahchnotmanager.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lymin.ptahchnotmanager.EditDataActivity
import com.lymin.ptahchnotmanager.model.ChnotModel
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.activities.LotteryDetailActivity

class LotteryListDetailAdapter(private val  context: Context, private val chnotList: List<ChnotModel>) : RecyclerView.Adapter<LotteryListDetailAdapter.ChnotViewHolder>() {

    inner class ChnotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var innerRecyclerView : RecyclerView = itemView.findViewById(R.id.innerRecyclerView)
        var dateTime : TextView = itemView.findViewById(R.id.tv_date_time)
        var btnEdit : ImageButton = itemView.findViewById(R.id.btn_edit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChnotViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chnot_item_edit, parent, false)
        return ChnotViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChnotViewHolder, position: Int) {
        val chnotItem = chnotList[position]

        holder.dateTime.text = "ថ្ងៃ ${chnotItem.date} ម៉ោង ${chnotItem.time}"
        val innerAdapter = ChnotDetailAdapter(chnotItem.details)
        holder.innerRecyclerView.adapter = innerAdapter

        holder.btnEdit.setOnClickListener {
            val intent = Intent(context, EditDataActivity::class.java)
            intent.putExtra("chnotDetailItem", chnotItem)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return chnotList.size
    }
}
