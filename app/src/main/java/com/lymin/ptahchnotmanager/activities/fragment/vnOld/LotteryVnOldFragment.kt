package com.lymin.ptahchnotmanager.activities.fragment.vnOld

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.activities.utils.Utils
import com.lymin.ptahchnotmanager.databinding.FragmentLotteryVnOldBinding
import com.lymin.ptahchnotmanager.firebaseHelper.FirebaseHelper
import com.lymin.ptahchnotmanager.model.LotteryVN1Model
import com.lymin.ptahchnotmanager.model.LotteryVN2Model

class LotteryVnOldFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLotteryVnOldBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_lottery_vn_old,
            container,
            false
        )

        binding.btnEdit1.setOnClickListener {
            startActivity(Intent(context, LotteryVN1Activity::class.java))
        }
        binding.btnEdit2.setOnClickListener {
            startActivity(Intent(context, LotteryVN2Activity::class.java))
        }


        getData410(binding)
        getData615(binding)

        return binding.root
    }

    private fun getData410(binding: FragmentLotteryVnOldBinding) {
        FirebaseHelper.getDataVN1(Utils.getYesterday(),object : FirebaseHelper.OnGetVN1CallBack{
            @SuppressLint("SetTextI18n")
            override fun onSuccess(data: LotteryVN1Model) {
                binding.tvDateTime.text = "ថ្ងៃ ${data.date} ម៉ោង 04:10"

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
            }

            override fun onFailed() {

            }
        })
    }
    private fun getData615(binding: FragmentLotteryVnOldBinding) {
        FirebaseHelper.getDataVN2(Utils.getYesterday(),object : FirebaseHelper.OnGetVN2CallBack{
            @SuppressLint("SetTextI18n")
            override fun onSuccess(data: LotteryVN2Model) {
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

            override fun onFailed() {

            }
        })
    }

}