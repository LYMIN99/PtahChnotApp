package com.lymin.ptahchnotmanager.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lymin.ptahchnotmanager.AddDataActivity
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.activities.LotteryDetailActivity
import com.lymin.ptahchnotmanager.model.ChnotDetailModel
import com.lymin.ptahchnotmanager.model.ChnotModel
import com.lymin.ptahchnotmanager.model.PostModel

class LotteryListAdapter(private val  context: Context, private val list: List<ChnotModel>) : RecyclerView.Adapter<LotteryListAdapter.ChnotDetailViewHolder>() {


    inner class ChnotDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)
        var result: TextView = itemView.findViewById(R.id.tv_result)
        var time: TextView = itemView.findViewById(R.id.tv_time)
//        var btnEdit: ImageButton = itemView.findViewById(R.id.btn_edit)
//        var btnDelete: ImageButton = itemView.findViewById(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChnotDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lottery_item, parent, false)
        return ChnotDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChnotDetailViewHolder, position: Int) {
        val chnotDetailItem = list[position]
      //  holder.name.text = chnotDetailItem.date
        holder.name.text = chnotDetailItem.date
        holder.time.text = chnotDetailItem.time
        holder.result.text = chnotDetailItem.details.size.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(context, LotteryDetailActivity::class.java)
            intent.putExtra("chnotDetailItem", chnotDetailItem)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
