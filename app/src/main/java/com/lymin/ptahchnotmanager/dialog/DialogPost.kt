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
import com.google.type.DateTime
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.adapter.SelectListAdapter
import com.lymin.ptahchnotmanager.adapter.SelectPostAdapter
import com.lymin.ptahchnotmanager.model.ChnotDetailModel
import com.lymin.ptahchnotmanager.model.PostModel
import com.lymin.ptahchnotmanager.model.TimeModel
import java.util.Objects
import java.util.UUID

class DialogPost(private val context: Context, private val oldData : PostModel?, private val onCallBack: OnCallBack) {
    init {
        initialize()
    }

    private fun initialize() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR)
        dialog.setContentView(R.layout.dialog_post)
        Objects.requireNonNull(dialog.window)!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(Objects.requireNonNull(dialog.window)!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog.window!!.attributes = lp
        val btnClose = dialog.findViewById<ImageButton>(R.id.btn_close)
        btnClose.setOnClickListener { dialog.dismiss() }
        val edPost : TextView = dialog.findViewById(R.id.ed_post)
        val btnSave : Button = dialog.findViewById(R.id.btn_confirm)

        if (oldData!=null){
            edPost.text = oldData.post
        }
        btnSave.setOnClickListener {
            if (edPost.text.toString().isEmpty()) {
                edPost.error = "Required"
                return@setOnClickListener
            }
            val id : String = oldData?.id ?: UUID.randomUUID().toString()
            val item = PostModel(id,edPost.text.toString())
            onCallBack.onConfirmClick(item)
            dialog.dismiss()
        }

        dialog.show()
    }

    interface OnCallBack {
        fun onConfirmClick(item: PostModel?)
    }
}