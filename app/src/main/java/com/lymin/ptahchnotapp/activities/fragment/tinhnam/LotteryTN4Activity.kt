package com.lymin.ptahchnotapp.activities.fragment.tinhnam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lymin.ptahchnotapp.R
import com.lymin.ptahchnotapp.databinding.ActivityLotteryTn4Binding
import com.lymin.ptahchnotapp.model.LotteryTN1Model
import com.lymin.ptahchnotapp.model.LotteryTN4Model

class LotteryTN4Activity : AppCompatActivity() {
    lateinit var binding: ActivityLotteryTn4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_lottery_tn4)

        initToolBar()
        val lotteryData = intent.getSerializableExtra("Lottery") as? LotteryTN4Model
        if (lotteryData != null) {
            initData(lotteryData)
        }

    }

    private fun initData(data: LotteryTN4Model) {

            binding.tvDateTime4.text = "ថ្ងៃ ${data.date} ម៉ោង ${data.time}"

        binding.aaaa2.text = data.a2
        binding.aaaa3.text = data.a3

        binding.aaab2.text = data.ab2
        binding.aaab3.text = data.ab3
        binding.aaac2.text = data.ac2
        binding.aaac3.text = data.ac3
        binding.aaad2.text = data.ad2

            binding.bbbb2.text = data.b2
            binding.bbbb3.text = data.b3
            binding.bbbb4.text = data.b4

            binding.cccc2.text = data.c2
            binding.cccc3.text = data.c3

            binding.dddd2.text = data.d2
            binding.dddd3.text = data.d3

            binding.loaaaa1.text = data.loa1
            binding.loaaaa2.text = data.loa2
            binding.loaaaa3.text = data.loa3

            binding.lobbbb1.text = data.lob1
            binding.lobbbb2.text = data.lob2
            binding.lobbbb3.text = data.lob3

            binding.locccc1.text = data.loc1
            binding.locccc2.text = data.loc2
            binding.locccc3.text = data.loc3

            binding.lodddd1.text = data.lod1
            binding.lodddd2.text = data.lod2
            binding.lodddd3.text = data.lod3

        binding.loeeee1.text = data.loe1
        binding.loeeee2.text = data.loe2
        binding.loeeee3.text = data.loe3

        binding.loffff1.text = data.lof1
        binding.loffff2.text = data.lof2
        binding.loffff3.text = data.lof3

        binding.logggg1.text = data.log1

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