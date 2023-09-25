package com.lymin.ptahchnotmanager.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.model.PostModel
import com.lymin.ptahchnotmanager.model.TimeModel

class SelectPostAdapter(private val list: List<PostModel>, private val selectedItem : String, private val onCallBack: OnCallBack) :
    RecyclerView.Adapter<SelectPostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.select_single_item, parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].post

        if (selectedItem == list[position].post){
            holder.imgSuccess.visibility = View.VISIBLE
        } else {
            holder.imgSuccess.visibility = View.GONE
        }


        holder.itemView.setOnClickListener {
            onCallBack.onCallBack(list[position])
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)
        var imgSuccess: ImageView = itemView.findViewById(R.id.img_done)
    }

    interface OnCallBack {
        fun onCallBack(selected: PostModel?)
    }
}