package com.lymin.ptahchnotmanager.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.adapter.SelectListAdapter
import com.lymin.ptahchnotmanager.adapter.SelectPostAdapter
import com.lymin.ptahchnotmanager.model.PostModel
import com.lymin.ptahchnotmanager.model.TimeModel
import java.util.Objects

class DialogSelectPost(private val context: Context, private val oldItem: String?, private val list : List<PostModel>, private val onCallBack: OnCallBack) {
    init {
        initialize()
    }

    private fun initialize() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR)
        dialog.setContentView(R.layout.dialog_select_list)
        Objects.requireNonNull(dialog.window)!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(true)
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(Objects.requireNonNull(dialog.window)!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog.window!!.attributes = lp
        val btnClose = dialog.findViewById<ImageButton>(R.id.btn_close)
        val recyclerView = dialog.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = SelectPostAdapter(list, oldItem.toString(),
            object : SelectPostAdapter.OnCallBack{
                override fun onCallBack(selected: PostModel?) {
                    onCallBack.onConfirmClick(selected)
                    dialog.dismiss()
                }
            })

        btnClose.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    interface OnCallBack {
        fun onConfirmClick(selectedItem: PostModel?)
    }
}