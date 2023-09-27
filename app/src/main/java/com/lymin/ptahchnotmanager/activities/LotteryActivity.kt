package com.lymin.ptahchnotmanager.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.lymin.ptahchnotmanager.AddDataActivity
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.adapter.ChnotAdapter
import com.lymin.ptahchnotmanager.adapter.LotteryListAdapter
import com.lymin.ptahchnotmanager.firebaseHelper.FirebaseHelper
import com.lymin.ptahchnotmanager.model.ChnotModel

class LotteryActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    lateinit var noDataLayout : LinearLayout
    val listLottery = mutableListOf<ChnotModel>()
    val adapter = LotteryListAdapter(this@LotteryActivity,listLottery)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottery)
        recyclerView = findViewById(R.id.recycler_view)
        noDataLayout = findViewById(R.id.ln_no_data)
        recyclerView.adapter = adapter

        initToolBar()

        findViewById<ImageButton>(R.id.btn_add).setOnClickListener {
            startActivity(Intent(this@LotteryActivity,AddDataActivity::class.java))
        }

    }
    private fun initToolBar() {
        val toolbar : Toolbar = findViewById(R.id.toolbar)
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

    private fun getData() {
        FirebaseHelper.getData(object  : FirebaseHelper.OnGetDataallBack{
            @SuppressLint("NotifyDataSetChanged")
            override fun onSuccess(list: MutableList<ChnotModel>) {
                Log.d("TAG", "getData: ${list.size}")
                listLottery.clear()
                listLottery.addAll(list)
                adapter.notifyDataSetChanged()
                noDataLayout.visibility = View.GONE
            }

            override fun onFailed() {
                //Show No Data
                noDataLayout.visibility = View.VISIBLE
            }
        })
    }
    override fun onResume() {
        getData()
        super.onResume()
    }
}