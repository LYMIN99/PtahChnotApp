package com.lymin.ptahchnotmanager.activities.fragment.tinhnam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.activities.fragment.vnOld.LotteryVN1Activity
import com.lymin.ptahchnotmanager.activities.utils.Utils
import com.lymin.ptahchnotmanager.databinding.FragmentLotteryTinhnameBinding
import com.lymin.ptahchnotmanager.databinding.FragmentLotteryVnOldBinding
import com.lymin.ptahchnotmanager.firebaseHelper.FirebaseHelper
import com.lymin.ptahchnotmanager.model.LotteryTN1Model
import com.lymin.ptahchnotmanager.model.LotteryVN1Model

class LotteryTinhnamFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLotteryTinhnameBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_lottery_tinhname,
            container,
            false
        )

        binding.btnEdit1.setOnClickListener {
            startActivity(Intent(context, LotteryTN1Activity::class.java))
        }
        binding.btnEdit2.setOnClickListener {
            startActivity(Intent(context, LotteryTN2Activity::class.java))
        }
        binding.btnEdit3.setOnClickListener {
            startActivity(Intent(context, LotteryTN3Activity::class.java))
        }
        binding.btnEdit4.setOnClickListener {
            startActivity(Intent(context, LotteryTN4Activity::class.java))
        }

        getData1015(binding)
        getData1315(binding)
        getData415(binding)
        getData615(binding)

        return binding.root
    }
    private fun getData1015(binding: FragmentLotteryTinhnameBinding) {
        FirebaseHelper.getDataTN1(Utils.getYesterday(),object : FirebaseHelper.OnGetTN1CallBack{
            @SuppressLint("SetTextI18n")
            override fun onSuccess(data: LotteryTN1Model) {
                binding.tvDateTime1.text = "ថ្ងៃ ${data.date} ម៉ោង 10:15"

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

            override fun onFailed() {

            }
        })
    }
    private fun getData1315(binding: FragmentLotteryTinhnameBinding) {
        FirebaseHelper.getDataTN1(Utils.getYesterday(),object : FirebaseHelper.OnGetTN1CallBack{
            @SuppressLint("SetTextI18n")
            override fun onSuccess(data: LotteryTN1Model) {
                binding.tvDateTime1.text = "ថ្ងៃ ${data.date} ម៉ោង 13:15"

                binding.tvAa2.text = data.a2
                binding.tvAa3.text = data.a3
                binding.tvAa4.text = data.a4

                binding.bb2.text = data.b2
                binding.bb3.text = data.b3
                binding.bb4.text = data.b4

                binding.cc2.text = data.c2
                binding.cc3.text = data.c3

                binding.dd2.text = data.d2
                binding.dd3.text = data.d3

                binding.ff2.text = data.f2
                binding.ff3.text = data.f3

                binding.nn2.text = data.n2
                binding.nn3.text = data.n3
                binding.nn4.text = data.n4

                binding.ii2.text = data.i2
                binding.ii3.text = data.i3

                binding.kk2.text = data.k2
                binding.kk3.text = data.k3
                binding.kk4.text = data.k4

                binding.oo2.text = data.o2
                binding.oo3.text = data.o3

                binding.zz2.text = data.z2
                binding.zz3.text = data.z3

                binding.pp2.text = data.p2
                binding.pp3.text = data.p3
                binding.pp4.text = data.p4

                binding.loaa1.text = data.loa1
                binding.loaa2.text = data.loa2
                binding.loaa3.text = data.loa3

                binding.lobb1.text = data.lob1
                binding.lobb2.text = data.lob2
                binding.lobb3.text = data.lob3

                binding.locc1.text = data.loc1
                binding.locc2.text = data.loc2
                binding.locc3.text = data.loc3

                binding.lodd1.text = data.lod1
                binding.lodd2.text = data.lod2
                binding.lodd3.text = data.lod3

                binding.loee1.text = data.loe1
                binding.loee2.text = data.loe2
            }

            override fun onFailed() {

            }
        })
    }
    private fun getData415(binding: FragmentLotteryTinhnameBinding) {
        FirebaseHelper.getDataTN1(Utils.getYesterday(),object : FirebaseHelper.OnGetTN1CallBack{
            @SuppressLint("SetTextI18n")
            override fun onSuccess(data: LotteryTN1Model) {
                binding.tvDateTime1.text = "ថ្ងៃ ${data.date} ម៉ោង 4:15"

                binding.tvAaa2.text = data.a2
                binding.tvAaa3.text = data.a3
                binding.tvAaa4.text = data.a4

                binding.bbb2.text = data.b2
                binding.bbb3.text = data.b3
                binding.bbb4.text = data.b4

                binding.ccc2.text = data.c2
                binding.ccc3.text = data.c3

                binding.ddd2.text = data.d2
                binding.ddd3.text = data.d3

                binding.fff2.text = data.f2
                binding.fff3.text = data.f3

                binding.nnn2.text = data.n2
                binding.nnn3.text = data.n3
                binding.nnn4.text = data.n4

                binding.iii2.text = data.i2
                binding.iii3.text = data.i3

                binding.kkk2.text = data.k2
                binding.kkk3.text = data.k3
                binding.kkk4.text = data.k4

                binding.ooo2.text = data.o2
                binding.ooo3.text = data.o3

                binding.zzz2.text = data.z2
                binding.zzz3.text = data.z3

                binding.ppp2.text = data.p2
                binding.ppp3.text = data.p3
                binding.ppp4.text = data.p4

                binding.loaaa1.text = data.loa1
                binding.loaaa2.text = data.loa2
                binding.loaaa3.text = data.loa3

                binding.lobbb1.text = data.lob1
                binding.lobbb2.text = data.lob2
                binding.lobbb3.text = data.lob3

                binding.loccc1.text = data.loc1
                binding.loccc2.text = data.loc2
                binding.loccc3.text = data.loc3

                binding.loddd1.text = data.lod1
                binding.loddd2.text = data.lod2
                binding.loddd3.text = data.lod3

                binding.loeee1.text = data.loe1
                binding.loeee2.text = data.loe2
            }

            override fun onFailed() {

            }
        })
    }
    private fun getData615(binding: FragmentLotteryTinhnameBinding) {
        FirebaseHelper.getDataTN1(Utils.getYesterday(),object : FirebaseHelper.OnGetTN1CallBack{
            @SuppressLint("SetTextI18n")
            override fun onSuccess(data: LotteryTN1Model) {
                binding.tvDateTime1.text = "ថ្ងៃ ${data.date} ម៉ោង 10:15"

                binding.tvAaaa2.text = data.a2
                binding.tvAaaa3.text = data.a3
                binding.tvAaaa4.text = data.a4

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
            }

            override fun onFailed() {

            }
        })
    }
}