package com.lymin.ptahchnotmanager.activities.fragment.vnOld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.activities.utils.Utils
import com.lymin.ptahchnotmanager.databinding.ActivityLotteryVn1Binding
import com.lymin.ptahchnotmanager.databinding.ActivityLotteryVn2Binding
import com.lymin.ptahchnotmanager.databinding.ActivityMainBinding
import com.lymin.ptahchnotmanager.dialog.DialogPickDate
import com.lymin.ptahchnotmanager.firebaseHelper.FirebaseHelper
import com.lymin.ptahchnotmanager.model.LotteryVN1Model
import com.lymin.ptahchnotmanager.model.LotteryVN2Model
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.UUID

class LotteryVN2Activity : AppCompatActivity() {
    lateinit var tvDate : TextView
    lateinit var binding: ActivityLotteryVn2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_lottery_vn2)

        initToolBar()
        if (binding!=null) {
            initClick()
        }
        initData()
    }

    private fun initData() {
        tvDate = findViewById(R.id.tv_date)
        val ysd = Utils.getYesterday()
        tvDate.text = ysd

        tvDate.setOnClickListener {
            DialogPickDate(this@LotteryVN2Activity,object : DialogPickDate.OnCallBack{
                override fun onConfirmClick(value: String?) {
                    tvDate.text = value
                }
            })
        }

    }

    private fun initToolBar() {
        val toolbar : androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        // var appbar : AppBarLayout = findViewById(R.id.appbar)

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            // Enable the back button
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        toolbar.navigationIcon?.setTint(resources.getColor(R.color.white))
        // Handle the back button click
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    private fun initClick() {
        binding.btnSave.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        val id = UUID.randomUUID().toString()

        var data = LotteryVN2Model(
            id,
            binding.tvDate.text.toString(),
            binding.tvTime.text.toString(),
            binding.aa2.text.toString(),
            binding.aa3.text.toString(),
            binding.ab2.text.toString(),
            binding.ab3.text.toString(),
            binding.ac2.text.toString(),
            binding.ac3.text.toString(),
            binding.ad2.text.toString(),
            binding.b2.text.toString(),
            binding.b3.text.toString(),
            binding.b4.text.toString(),
            binding.c2.text.toString(),
            binding.c3.text.toString(),
            binding.d2.text.toString(),
            binding.d3.text.toString(),
            binding.loa1.text.toString(),
            binding.loa2.text.toString(),
            binding.loa3.text.toString(),
            binding.lob1.text.toString(),
            binding.lob2.text.toString(),
            binding.lob3.text.toString(),
            binding.loc1.text.toString(),
            binding.loc2.text.toString(),
            binding.loc3.text.toString(),
            binding.lod1.text.toString(),
            binding.lod2.text.toString(),
            binding.lod3.text.toString(),
            binding.loe1.text.toString(),
            binding.loe2.text.toString(),
            binding.loe3.text.toString(),
            binding.lof1.text.toString(),
            binding.lof2.text.toString(),
            binding.lof3.text.toString(),
            binding.log1.text.toString(),
            binding.log2.text.toString(),
            binding.log3.text.toString(),
            )

        FirebaseHelper().saveLotteryVn2ToFirestore(data,object : FirebaseHelper.OnUploadCallBack{
            override fun onSuccess() {
                Toast.makeText(this@LotteryVN2Activity,"Upload Success", Toast.LENGTH_SHORT).show()
                finish()
            }

            override fun onFailed() {
                Toast.makeText(this@LotteryVN2Activity,"Upload Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}