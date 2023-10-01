package com.lymin.ptahchnotapp.activities.fragment.tinhnam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.lymin.ptahchnotapp.R
import com.lymin.ptahchnotapp.databinding.ActivityLotteryTn1Binding
import com.lymin.ptahchnotapp.firebaseHelper.FirebaseHelper
import com.lymin.ptahchnotapp.model.LotteryTN1Model
import java.util.UUID

class LotteryTN1Activity : AppCompatActivity() {
    lateinit var binding: ActivityLotteryTn1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_lottery_tn1)

        initToolBar()
        val lotteryData = intent.getSerializableExtra("Lottery") as? LotteryTN1Model
        if (lotteryData != null) {
            initData(lotteryData)
        }

    }

    private fun initData(data: LotteryTN1Model) {

            binding.tvDateTime1.text = "ថ្ងៃ ${data.date} ម៉ោង ${data.time}"

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

            binding.n2.text = data.n2
            binding.n3.text = data.n3
            binding.n4.text = data.n4

            binding.i2.text = data.i2
            binding.i3.text = data.i3

            binding.k2.text = data.k2
            binding.k3.text = data.k3
            binding.k4.text = data.k4

            binding.o2.text = data.o2
            binding.o3.text = data.o3

            binding.z2.text = data.z2
            binding.z3.text = data.z3

            binding.p2.text = data.p2
            binding.p3.text = data.p3
            binding.p4.text = data.p4

            binding.loa1.text = data.loa1
            binding.loa2.text = data.loa2
            binding.loa3.text = data.loa3

            binding.lob1.text = data.lob1
            binding.lob2.text = data.lob2
            binding.lob3.text = data.lob3

            binding.loc1.text = data.loc1
            binding.loc2.text = data.loc2
            binding.loc3.text = data.loc3

            binding.lod1.text = data.lod1
            binding.lod2.text = data.lod2
            binding.lod3.text = data.lod3

            binding.loe1.text = data.loe1
            binding.loa2.text = data.loe2

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