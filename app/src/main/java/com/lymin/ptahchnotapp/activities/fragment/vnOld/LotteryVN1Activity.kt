package com.lymin.ptahchnotapp.activities.fragment.vnOld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lymin.ptahchnotapp.R
import com.lymin.ptahchnotapp.databinding.ActivityLotteryVn1Binding
import com.lymin.ptahchnotapp.model.LotteryVN1Model

class LotteryVN1Activity : AppCompatActivity() {
    lateinit var binding: ActivityLotteryVn1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_lottery_vn1)


        initToolBar()
        val lotteryData = intent.getSerializableExtra("Lottery") as? LotteryVN1Model
        if (lotteryData != null) {
            initData(lotteryData)
        }
    }

    private fun initData(data: LotteryVN1Model) {

            binding.tvDateTime.text = "ថ្ងៃ ${data.date} ម៉ោង ${data.time}"

            binding.tvA2.text = data.a2
            binding.tvA3.text = data.a3
            binding.tvA4.text = data.a4

            binding.b2.text = data.b2
            binding.b3.text = data.b3
            binding.b4.text = data.b4

            binding.c2.text = data.c2
            binding.c3.text = data.c3

            binding.d2.text = data.d2
            binding.d3.text = data.d3

            binding.f2.text = data.f2
            binding.f3.text = data.f3
            binding.f4.text = data.f3

            binding.n2.text = data.n2
            binding.n3.text = data.n3
            binding.n4.text = data.n4

            binding.i2.text = data.i2
            binding.i3.text = data.i3
            binding.i4.text = data.i4

            binding.k2.text = data.k2
            binding.k3.text = data.k3
            binding.k4.text = data.k4

            binding.o2.text = data.o2
            binding.o3.text = data.o3

            binding.v12.text = data.va2
            binding.v13.text = data.va3

            binding.v22.text = data.vb2
            binding.v23.text = data.vb3

            binding.loa1.text = data.la1
            binding.loa2.text = data.la2
            binding.loa3.text = data.la3

            binding.lob1.text = data.lb1
            binding.lob2.text = data.lb2
            binding.lob3.text = data.lb3

            binding.loc1.text = data.lc1
            binding.loc2.text = data.lc2
            binding.loc3.text = data.lc3

            binding.lod1.text = data.ld1
            binding.lod2.text = data.ld2
            binding.lod3.text = data.ld3

        binding.loe1.text = data.le1
        binding.loe2.text = data.le2
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