package com.lymin.ptahchnotmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.adapter.ChnotAdapter
import com.lymin.ptahchnotmanager.firebaseHelper.FirebaseHelper
import com.lymin.ptahchnotmanager.model.ChnotModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    lateinit var noDataLayout : LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        noDataLayout = findViewById(R.id.ln_no_data)

        getData()
        findViewById<FloatingActionButton>(R.id.btn_add).setOnClickListener {
            startActivity(Intent(this@MainActivity,AddDataActivity::class.java))
        }

    }

    private fun getData() {
       FirebaseHelper.getData(object  : FirebaseHelper.OnGetDataallBack{
            override fun onSuccess(list: MutableList<ChnotModel>) {
                Log.d("TAG", "getData: ${list.size}")
                val adapter = ChnotAdapter(list)
                recyclerView.adapter = adapter
                noDataLayout.visibility = View.GONE
            }

            override fun onFailed() {
                //Show No Data
                noDataLayout.visibility = View.VISIBLE
            }
        })

    }

}