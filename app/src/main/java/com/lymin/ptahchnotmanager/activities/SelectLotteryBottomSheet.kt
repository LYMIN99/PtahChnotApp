package com.lymin.ptahchnotmanager.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.LinearLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.activities.fragment.vnOld.LotteryVN1Activity

class SelectLotteryBottomSheet(
    private val context: Context,
) {
    //    private BottomSheetBehavior mBehavior;
    private var mBottomSheetDialog: BottomSheetDialog? = null
    @SuppressLint("SetTextI18n")
    fun show() {
        val li: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        @SuppressLint("InflateParams") val view: View =
            li.inflate(R.layout.select_lottery_btsh, null)
        val btnClose = view.findViewById<ImageButton>(R.id.btn_close)

        view.findViewById<LinearLayout>(R.id.btn_1).setOnClickListener {
            mBottomSheetDialog!!.dismiss()
            context.startActivity(Intent(context,LotteryVN1Activity::class.java))
        }
        view.findViewById<LinearLayout>(R.id.btn2).setOnClickListener {
            mBottomSheetDialog!!.dismiss()
            context.startActivity(Intent(context,LotteryVN1Activity::class.java))
        }
        view.findViewById<LinearLayout>(R.id.btn_3).setOnClickListener {
            mBottomSheetDialog!!.dismiss()
            context.startActivity(Intent(context,LotteryVN1Activity::class.java))
        }
        view.findViewById<LinearLayout>(R.id.btn_4).setOnClickListener {
            mBottomSheetDialog!!.dismiss()
            context.startActivity(Intent(context,LotteryVN1Activity::class.java))
        }
        view.findViewById<LinearLayout>(R.id.btn_5).setOnClickListener {
            mBottomSheetDialog!!.dismiss()
            context.startActivity(Intent(context,LotteryVN1Activity::class.java))
        }
        view.findViewById<LinearLayout>(R.id.btn_6).setOnClickListener {
            mBottomSheetDialog!!.dismiss()
            context.startActivity(Intent(context,LotteryVN1Activity::class.java))
        }


        btnClose.setOnClickListener { mBottomSheetDialog!!.dismiss() }
        mBottomSheetDialog = BottomSheetDialog(context)
        mBottomSheetDialog!!.setContentView(view)
        mBottomSheetDialog!!.window!!.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        mBottomSheetDialog!!.show()
        mBottomSheetDialog!!.setOnDismissListener {
            mBottomSheetDialog = null
        }
    }
}