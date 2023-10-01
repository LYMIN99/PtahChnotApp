package com.lymin.ptahchnotapp.activities.fragment.vnOld

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.lymin.ptahchnotapp.R
import com.lymin.ptahchnotapp.activities.utils.Utils
import com.lymin.ptahchnotapp.databinding.FragmentLotteryVnOldBinding
import com.lymin.ptahchnotapp.firebaseHelper.FirebaseHelper
import com.lymin.ptahchnotapp.model.LotteryVN1Model
import com.lymin.ptahchnotapp.model.LotteryVN2Model

class LotteryVnOldFragment : Fragment() {
    var day : Long = 1 //1 = yesterday
    lateinit var binding: FragmentLotteryVnOldBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_lottery_vn_old,
            container,
            false
        )

        getAllData(day)

        binding.btnDayBack.setOnClickListener {
            day += 1
            getAllData(day)

        }
        binding.dayNew.setOnClickListener {
            day = 0
            getAllData(day)
        }
        binding.dayForward.setOnClickListener {
            if (day>0) {
                day -= 1
                getAllData(day)
            }
        }

        return binding.root
    }

    private fun getAllData(day: Long) {
        getData410(binding,day)
        getData615(binding,day)

    }

    @SuppressLint("SetTextI18n")
    private fun getData410(binding: FragmentLotteryVnOldBinding, day: Long) {
        binding.tvDateTime.text = "ថ្ងៃ ${Utils.getDay(day)} ម៉ោង 04:10"
        FirebaseHelper.getDataVN1(Utils.getYesterday(),object : FirebaseHelper.OnGetVN1CallBack{
            @SuppressLint("SetTextI18n")
            override fun onSuccess(data: LotteryVN1Model) {

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
                binding.tvA2.text =""
                binding.tvA3.text =""
                binding.tvA4.text =""
                binding.b2.text =""
                binding.b3.text =""
                binding.b4.text =""
                binding.c2.text =""
                binding.c3.text =""
                binding.d2.text =""
                binding.d3.text =""
                binding.f2.text =""
                binding.f3.text =""
                binding.f4.text =""
                binding.n2.text =""
                binding.n3.text =""
                binding.n4.text =""
                binding.i2.text =""
                binding.i3.text =""
                binding.i4.text =""
                binding.k2.text =""
                binding.k3.text =""
                binding.k4.text =""
                binding.o2.text =""
                binding.o3.text =""
                binding.v12.text = ""
                binding.v13.text = ""
                binding.v22.text = ""
                binding.v23.text = ""
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
            }
        })
    }
    @SuppressLint("SetTextI18n")
    private fun getData615(binding: FragmentLotteryVnOldBinding, day: Long) {
        binding.tvDateTime2.text = "ថ្ងៃ ${Utils.getDay(day)} ម៉ោង 06:10"
        FirebaseHelper.getDataVN2(Utils.getYesterday(),object : FirebaseHelper.OnGetVN2CallBack{
            @SuppressLint("SetTextI18n")
            override fun onSuccess(data: LotteryVN2Model) {
              //  binding.tvDateTime2.text = "ថ្ងៃ ${data.date} ម៉ោង 06:10"

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

                binding.aa2.text =""
                binding.aa3.text =""
                binding.ab2.text =""
                binding.ab3.text =""
                binding.ac2.text =""
                binding.ac3.text =""
                binding.ad2.text =""
                binding.bb2.text = ""
                binding.bb3.text = ""
                binding.bb4.text = ""
                binding.cc2.text = ""
                binding.cc3.text = ""
                binding.dd2.text = ""
                binding.dd3.text = ""
                binding.loaa1.text =""
                binding.loaa2.text =""
                binding.loaa3.text =""
                binding.lobb1.text =""
                binding.lobb2.text =""
                binding.lobb3.text =""
                binding.locc1.text =""
                binding.locc2.text =""
                binding.locc3.text =""
                binding.lodd1.text =""
                binding.lodd2.text =""
                binding.lodd3.text =""
                binding.loee1.text =""
                binding.loee2.text =""
                binding.loee3.text =""
                binding.loff1.text =""
                binding.loff2.text =""
                binding.loff3.text =""
                binding.logg1.text =""
                binding.logg2.text =""
                binding.logg3.text =""
            }
        })
    }

}