package com.lymin.ptahchnotmanager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.model.ChnotDetailModel
import com.lymin.ptahchnotmanager.model.PostModel

class PostListAdapter(private val list: List<PostModel>, private val onCallBack: OnCallBack) : RecyclerView.Adapter<PostListAdapter.ChnotDetailViewHolder>() {


    inner class ChnotDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)
        var btnEdit: TextView = itemView.findViewById(R.id.btn_edit)
        var btnDelete: TextView = itemView.findViewById(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChnotDetailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_data_item, parent, false)
        return ChnotDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChnotDetailViewHolder, position: Int) {
        val chnotDetailItem = list[position]
        holder.name.text = chnotDetailItem.post


        holder.btnEdit.setOnClickListener {
            onCallBack.onEdit(chnotDetailItem,position)
        }

        holder.btnDelete.setOnClickListener {
            onCallBack.onDelete(chnotDetailItem,position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnCallBack {
        fun onEdit(item: PostModel?,position: Int)
        fun onDelete(item: PostModel?,position: Int)
    }
}
