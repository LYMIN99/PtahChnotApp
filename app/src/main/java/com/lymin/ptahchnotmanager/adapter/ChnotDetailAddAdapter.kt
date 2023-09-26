package com.lymin.ptahchnotmanager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.model.ChnotDetailModel

class ChnotDetailAddAdapter(private val chnotDetailList: List<ChnotDetailModel>, private val onCallBack: OnCallBack) : RecyclerView.Adapter<ChnotDetailAddAdapter.ChnotDetailViewHolder>() {


    inner class ChnotDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var post: TextView = itemView.findViewById(R.id.tv_post)
        var number2: TextView = itemView.findViewById(R.id.tv_number2)
        var number3: TextView = itemView.findViewById(R.id.tv_number3)
        var number4: TextView = itemView.findViewById(R.id.tv_number4)
        var btnEdit: ImageButton = itemView.findViewById(R.id.btn_edit)
        var btnDelete: ImageButton = itemView.findViewById(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChnotDetailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chnot_item_detail_add, parent, false)
        return ChnotDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChnotDetailViewHolder, position: Int) {
        val chnotDetailItem = chnotDetailList[position]
        holder.post.text = chnotDetailItem.post
        holder.number2.text = chnotDetailItem.number2.toString()
        holder.number3.text = chnotDetailItem.number3.toString()
        holder.number4.text = chnotDetailItem.number4.toString()

        holder.btnEdit.setOnClickListener {
            onCallBack.onEdit(chnotDetailItem,position)
        }

        holder.btnDelete.setOnClickListener {
            onCallBack.onDelete(chnotDetailItem,position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return chnotDetailList.size
    }

    interface OnCallBack {
        fun onEdit(item: ChnotDetailModel?,position: Int)
        fun onDelete(item: ChnotDetailModel?,position: Int)
    }
}
