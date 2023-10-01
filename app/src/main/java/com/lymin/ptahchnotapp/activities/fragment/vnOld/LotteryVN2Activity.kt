package com.lymin.ptahchnotapp.activities.fragment.vnOld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lymin.ptahchnotapp.R
import com.lymin.ptahchnotapp.databinding.ActivityLotteryVn2Binding
import com.lymin.ptahchnotapp.model.LotteryVN2Model

class LotteryVN2Activity : AppCompatActivity() {
    lateinit var binding: ActivityLotteryVn2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_lottery_vn2)

        initToolBar()
        val lotteryData = intent.getSerializableExtra("Lottery") as? LotteryVN2Model
        if (lotteryData != null) {
            initData(lotteryData)
        }
    }

    private fun initData(data: LotteryVN2Model) {
            binding.tvDateTime2.text = "ថ្ងៃ ${data.date} ម៉ោង 06:10"

            binding.aa2.text = data.aa2
            binding.aa3.text = data.aa3

            binding.ab2.text = data.ab2
            binding.ab3.text = data.ab3

            binding.ac2.text = data.ac2
            binding.ac3.text = data.ac3

            binding.ad2.text = data.ad2

            binding.bb2.text = data.b2
            binding.bb3.text = data.b3
            binding.bb4.text = data.b4

            binding.cc2.text = data.c2
            binding.cc3.text = data.c3

            binding.dd2.text = data.d2
            binding.dd3.text = data.d3

            binding.loaa1.text = data.la1
            binding.loaa2.text = data.la2
            binding.loaa3.text = data.la3

            binding.lobb1.text = data.lb1
            binding.lobb2.text = data.lb2
            binding.lobb3.text = data.lb3

            binding.locc1.text = data.lc1
            binding.locc2.text = data.lc2
            binding.locc3.text = data.lc3

            binding.lodd1.text = data.ld1
            binding.lodd2.text = data.ld2
            binding.lodd3.text = data.ld3

            binding.loee1.text = data.le1
            binding.loee2.text = data.le2
            binding.loee3.text = data.le3

            binding.loff1.text = data.lf1
            binding.loff2.text = data.lf2
            binding.loff3.text = data.lf3

            binding.logg1.text = data.lg1
            binding.logg2.text = data.lg2
            binding.logg3.text = data.lg3

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
}