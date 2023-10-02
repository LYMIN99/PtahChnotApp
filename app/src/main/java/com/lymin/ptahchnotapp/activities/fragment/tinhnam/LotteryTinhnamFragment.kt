package com.lymin.ptahchnotapp.activities.fragment.tinhnam

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.lymin.ptahchnotapp.R
import com.lymin.ptahchnotapp.activities.utils.Utils
import com.lymin.ptahchnotapp.databinding.FragmentLotteryTinhnameBinding
import com.lymin.ptahchnotapp.firebaseHelper.FirebaseHelper
import com.lymin.ptahchnotapp.model.LotteryTN1Model
import com.lymin.ptahchnotapp.model.LotteryTN4Model

class LotteryTinhnamFragment : Fragment() {
    var day : Long = 1 //1 = yesterday
    lateinit var binding: FragmentLotteryTinhnameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_lottery_tinhname,
            container,
            false
        )
        getAllData(day)

        binding.btnDayBack.setOnClickListener {
            day += 1
            getAllData(day)

        }
        binding.btnDayNew.setOnClickListener {
            day = 0
            getAllData(day)
        }
        binding.btnDayForward.setOnClickListener {
            if (day>0) {
                day -= 1
                getAllData(day)
            }
        }

        return binding.root
    }
    private fun getAllData(day: Long){
        getData1015(binding,day)
        getData1315(binding,day)
        getData415(binding,day)
        getData615(binding,day)
    }
    private fun getData1015(binding: FragmentLotteryTinhnameBinding, day: Long) {
        binding.tvDateTime1.text =  "ថ្ងៃ ${Utils.getDay(day)} ម៉ោង 10:15"
        FirebaseHelper.getDataTN1(Utils.getDay(day),object : FirebaseHelper.OnGetTN1CallBack{
            @SuppressLint("SetTextI18n")
            override fun onSuccess(data: LotteryTN1Model) {
                    //  binding.tvDateTime1.text = "ថ្ងៃ ${data.date} ម៉ោង 10:15"
                binding.btnView.setOnClickListener {
                    val intent = Intent(context, LotteryTN1Activity::class.java)
                    intent.putExtra("Lottery", data)
                    context!!.startActivity(intent)
                }
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
                binding.btnView.setOnClickListener {
                    val intent = Intent(context, LotteryTN1Activity::class.java)
                    context!!.startActivity(intent)
                }
                binding.tvA2.text = ""
                binding.tvA3.text = ""
                binding.tvA4.text = ""
                binding.b2.text = ""
                binding.b3.text = ""
                binding.b4.text = ""
                binding.c2.text = ""
                binding.c3.text = ""
                binding.d2.text = ""
                binding.d3.text = ""
                binding.f2.text = ""
                binding.f3.text = ""
                binding.n2.text = ""
                binding.n3.text = ""
                binding.n4.text = ""
                binding.i2.text = ""
                binding.i3.text = ""
                binding.k2.text = ""
                binding.k3.text = ""
                binding.k4.text = ""
                binding.o2.text = ""
                binding.o3.text = ""
                binding.z2.text = ""
                binding.z3.text = ""
                binding.p2.text = ""
                binding.p3.text = ""
                binding.p4.text = ""
                binding.loa1.text = ""
                binding.loa2.text = ""
                binding.loa3.text = ""
                binding.lob1.text = ""
                binding.lob2.text = ""
                binding.lob3.text = ""
                binding.loc1.text = ""
                binding.loc2.text = ""
                binding.loc3.text = ""
                binding.lod1.text = ""
                binding.lod2.text = ""
                binding.lod3.text = ""
                binding.loe1.text = ""
                binding.loa2.text = ""
            }
        })

    }
    private fun getData1315(binding: FragmentLotteryTinhnameBinding, day: Long) {
        binding.tvDateTime2.text =  "ថ្ងៃ ${Utils.getDay(day)} ម៉ោង 13:15"
        FirebaseHelper.getDataTN2(Utils.getDay(day),object : FirebaseHelper.OnGetTN1CallBack{
            @SuppressLint("SetTextI18n")
            override fun onSuccess(data: LotteryTN1Model) {
                binding.btnView2.setOnClickListener {
                    val intent = Intent(context, LotteryTN1Activity::class.java)
                    intent.putExtra("Lottery", data)
                    context!!.startActivity(intent)
                }

//                binding.tvDateTime1.text = "ថ្ងៃ ${data.date} ម៉ោង 13:15"

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
                binding.btnView2.setOnClickListener {
                    val intent = Intent(context, LotteryTN1Activity::class.java)
                    context!!.startActivity(intent)
                }
                binding.tvAa2.text = ""
                binding.tvAa3.text = ""
                binding.tvAa4.text = ""
                binding.bb2.text = ""
                binding.bb3.text = ""
                binding.bb4.text = ""
                binding.cc2.text = ""
                binding.cc3.text = ""
                binding.dd2.text = ""
                binding.dd3.text = ""
                binding.ff2.text = ""
                binding.ff3.text = ""
                binding.nn2.text = ""
                binding.nn3.text = ""
                binding.nn4.text = ""
                binding.ii2.text = ""
                binding.ii3.text = ""
                binding.kk2.text = ""
                binding.kk3.text = ""
                binding.kk4.text = ""
                binding.oo2.text = ""
                binding.oo3.text = ""
                binding.zz2.text = ""
                binding.zz3.text = ""
                binding.pp2.text = ""
                binding.pp3.text = ""
                binding.pp4.text = ""
                binding.loaa1.text = ""
                binding.loaa2.text = ""
                binding.loaa3.text = ""
                binding.lobb1.text = ""
                binding.lobb2.text = ""
                binding.lobb3.text = ""
                binding.locc1.text = ""
                binding.locc2.text = ""
                binding.locc3.text = ""
                binding.lodd1.text = ""
                binding.lodd2.text = ""
                binding.lodd3.text = ""
                binding.loee1.text = ""
                binding.loee2.text = ""
            }
        })
    }
    private fun getData415(binding: FragmentLotteryTinhnameBinding, day: Long) {
        binding.tvDateTime3.text =  "ថ្ងៃ ${Utils.getDay(day)} ម៉ោង 4:15"
        FirebaseHelper.getDataTN3(Utils.getDay(day),object : FirebaseHelper.OnGetTN1CallBack{
            @SuppressLint("SetTextI18n")
            override fun onSuccess(data: LotteryTN1Model) {
                binding.btnView3.setOnClickListener {
                    val intent = Intent(context, LotteryTN1Activity::class.java)
                    intent.putExtra("Lottery", data)
                    context!!.startActivity(intent)
                }

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
                binding.btnView3.setOnClickListener {
                    val intent = Intent(context, LotteryTN1Activity::class.java)
                    context!!.startActivity(intent)
                }
                binding.tvAaa2.text = ""
                binding.tvAaa3.text = ""
                binding.tvAaa4.text = ""
                binding.bbb2.text = ""
                binding.bbb3.text = ""
                binding.bbb4.text = ""
                binding.ccc2.text = ""
                binding.ccc3.text = ""
                binding.ddd2.text = ""
                binding.ddd3.text = ""
                binding.fff2.text = ""
                binding.fff3.text = ""
                binding.nnn2.text = ""
                binding.nnn3.text = ""
                binding.nnn4.text = ""
                binding.iii2.text = ""
                binding.iii3.text = ""
                binding.kkk2.text = ""
                binding.kkk3.text = ""
                binding.kkk4.text = ""
                binding.ooo2.text = ""
                binding.ooo3.text = ""
                binding.zzz2.text = ""
                binding.zzz3.text = ""
                binding.ppp2.text = ""
                binding.ppp3.text = ""
                binding.ppp4.text = ""
                binding.loaaa1.text = ""
                binding.loaaa2.text = ""
                binding.loaaa3.text = ""
                binding.lobbb1.text = ""
                binding.lobbb2.text = ""
                binding.lobbb3.text = ""
                binding.loccc1.text = ""
                binding.loccc2.text = ""
                binding.loccc3.text = ""
                binding.loddd1.text = ""
                binding.loddd2.text = ""
                binding.loddd3.text = ""
                binding.loeee1.text = ""
                binding.loeee2.text = ""
            }
        })
    }
    private fun getData615(binding: FragmentLotteryTinhnameBinding, day: Long) {
        binding.tvDateTime4.text = "ថ្ងៃ ${Utils.getDay(day)} ម៉ោង 6:15"

        FirebaseHelper.getDataTN4(Utils.getDay(day),object : FirebaseHelper.OnGetTN4CallBack{
            @SuppressLint("SetTextI18n")
            override fun onSuccess(data: LotteryTN4Model) {
                binding.btnView4.setOnClickListener {
                    val intent = Intent(context, LotteryTN4Activity::class.java)
                    intent.putExtra("Lottery", data)
                    context!!.startActivity(intent)
                }

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
            }

            override fun onFailed() {
                binding.btnView4.setOnClickListener {
                    val intent = Intent(context, LotteryTN4Activity::class.java)
                    context!!.startActivity(intent)
                }
                binding.aaaa2.text = ""
                binding.aaaa3.text = ""

                binding.aaab2.text = ""
                binding.aaab3.text = ""
                binding.aaac2.text = ""
                binding.aaac3.text = ""
                binding.aaad2.text = ""
                binding.bbbb2.text = ""
                binding.bbbb3.text = ""
                binding.bbbb4.text = ""
                binding.cccc2.text = ""
                binding.cccc3.text = ""
                binding.dddd2.text = ""
                binding.dddd3.text = ""
                binding.loaaaa1.text = ""
                binding.loaaaa2.text = ""
                binding.loaaaa3.text = ""
                binding.lobbbb1.text = ""
                binding.lobbbb2.text = ""
                binding.lobbbb3.text = ""
                binding.locccc1.text = ""
                binding.locccc2.text = ""
                binding.locccc3.text = ""
                binding.lodddd1.text = ""
                binding.lodddd2.text = ""
                binding.lodddd3.text = ""
                binding.loeeee1.text = ""
                binding.loeeee2.text = ""
            }
        })
    }
}