package com.lymin.ptahchnotmanager.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.adapter.SelectListAdapter
import com.lymin.ptahchnotmanager.adapter.SelectPostAdapter
import com.lymin.ptahchnotmanager.model.ChnotDetailModel
import com.lymin.ptahchnotmanager.model.PostModel
import com.lymin.ptahchnotmanager.model.TimeModel
import java.util.Objects

class DialogAddChnot(private val context: Context, private val list : List<PostModel>, private val onCallBack: OnCallBack) {
    init {
        initialize()
    }

    private fun initialize() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR)
        dialog.setContentView(R.layout.dialog_chnot_detail)
        Objects.requireNonNull(dialog.window)!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(Objects.requireNonNull(dialog.window)!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog.window!!.attributes = lp
        val btnClose = dialog.findViewById<ImageButton>(R.id.btn_close)
        btnClose.setOnClickListener { dialog.dismiss() }
        val tvPost : TextView = dialog.findViewById(R.id.tv_post)
        val edNumber : EditText = dialog.findViewById(R.id.ed_number)
        val btnSave : Button = dialog.findViewById(R.id.btn_confirm)

        tvPost.setOnClickListener {
            DialogSelectPost(context,tvPost.text.toString(),list,object : DialogSelectPost.OnCallBack{
                override fun onConfirmClick(selectedItem: PostModel?) {
                    if (selectedItem != null) {
                        tvPost.text = selectedItem.post
                    }
                }
            })
        }

        btnSave.setOnClickListener {
            if (tvPost.text.toString().isEmpty()) {
                Toast.makeText(context, "Please Select a post", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (edNumber.text.toString().isEmpty()) {
                edNumber.error = "Please Input Number"
                return@setOnClickListener
            }

            val item = ChnotDetailModel(tvPost.text.toString(),edNumber.text.toString())
            onCallBack.onConfirmClick(item)
        }

        dialog.show()
    }

    interface OnCallBack {
        fun onConfirmClick(item: ChnotDetailModel?)
    }
}