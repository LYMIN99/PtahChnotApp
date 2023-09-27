package com.lymin.ptahchnotmanager.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.model.ChnotDetailModel
import com.lymin.ptahchnotmanager.model.PostModel
import java.util.Objects

class DialogUpdateChnot(
    private val context: Context,
    private val list: List<PostModel>,
    private val item: ChnotDetailModel?,
    private val onCallBack: OnCallBack
) {
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
        val edNumber2 : EditText = dialog.findViewById(R.id.ed_number2)
        val edNumber3 : EditText = dialog.findViewById(R.id.ed_number3)
        val edNumber4 : EditText = dialog.findViewById(R.id.ed_number4)
        val btnSave : Button = dialog.findViewById(R.id.btn_confirm)

        if (item!=null){
            edNumber2.setText(item.number2.toString())
            edNumber3.setText(item.number3.toString())
            edNumber4.setText(item.number4.toString())
            tvPost.text = item.post.toString()
        }
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

            if (edNumber2.text.toString().isEmpty() || edNumber2.text.length<2) {
                edNumber2.error = "Please Input Number"
                return@setOnClickListener
            }

            if (item!=null) {
                val itemX = ChnotDetailModel(
                    item.id,
                    tvPost.text.toString(),
                    edNumber2.text.toString(),
                    edNumber3.text.toString(),
                    edNumber4.text.toString()
                )
                onCallBack.onConfirmClick(itemX)
                dialog.dismiss()
            } else {
                Toast.makeText(context,"Error Update",Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }

        dialog.show()
    }

    interface OnCallBack {
        fun onConfirmClick(item: ChnotDetailModel?)
    }
}