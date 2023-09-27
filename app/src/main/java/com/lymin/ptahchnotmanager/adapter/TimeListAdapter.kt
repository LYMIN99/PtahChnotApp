package com.lymin.ptahchnotmanager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.model.ChnotDetailModel
import com.lymin.ptahchnotmanager.model.PostModel
import com.lymin.ptahchnotmanager.model.TimeModel

class TimeListAdapter(private val list: List<TimeModel>, private val onCallBack: OnCallBack) : RecyclerView.Adapter<TimeListAdapter.ChnotDetailViewHolder>() {


    inner class ChnotDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)
        var btnEdit: ImageButton = itemView.findViewById(R.id.btn_edit)
        var btnDelete: ImageButton = itemView.findViewById(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChnotDetailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_data_item, parent, false)
        return ChnotDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChnotDetailViewHolder, position: Int) {
        val item = list[position]
        holder.name.text = item.time


        holder.btnEdit.setOnClickListener {
            onCallBack.onEdit(item,position)
        }

        holder.btnDelete.setOnClickListener {
            onCallBack.onDelete(item,position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnCallBack {
        fun onEdit(item: TimeModel?,position: Int)
        fun onDelete(item: TimeModel?,position: Int)
    }
}
