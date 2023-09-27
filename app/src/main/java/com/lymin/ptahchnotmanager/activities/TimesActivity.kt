package com.lymin.ptahchnotmanager.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.adapter.PostListAdapter
import com.lymin.ptahchnotmanager.adapter.TimeListAdapter
import com.lymin.ptahchnotmanager.dialog.DialogPost
import com.lymin.ptahchnotmanager.dialog.DialogTime
import com.lymin.ptahchnotmanager.firebaseHelper.FirebaseHelper
import com.lymin.ptahchnotmanager.model.PostModel
import com.lymin.ptahchnotmanager.model.TimeModel

class TimesActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    lateinit var noDataLayout : LinearLayout
    val listTimes = mutableListOf<TimeModel>()
    val adapter = TimeListAdapter(listTimes,object : TimeListAdapter.OnCallBack{
        override fun onEdit(itemOld: TimeModel?, position: Int) {
            DialogTime(this@TimesActivity,itemOld,object : DialogTime.OnCallBack{
                @SuppressLint("NotifyDataSetChanged")
                override fun onConfirmClick(itemUpdate: TimeModel?) {
                    if (itemUpdate != null) {
                        listTimes.remove(itemOld)
                        listTimes.add(position,itemUpdate)
                        recyclerView.adapter!!.notifyDataSetChanged()
                        //adapter.notifyDataSetChanged()
                    }
                }
            })
        }

        override fun onDelete(item: TimeModel?, position: Int) {
            listTimes.remove(item)
        }
    })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_times)
        recyclerView = findViewById(R.id.recycler_view)
        noDataLayout = findViewById(R.id.ln_no_data)

        initToolBar()

        findViewById<ImageButton>(R.id.btn_add).setOnClickListener {
            DialogTime(this@TimesActivity,null,object : DialogTime.OnCallBack{
                @SuppressLint("NotifyDataSetChanged")
                override fun onConfirmClick(item: TimeModel?) {
                    if (item != null) {
                        listTimes.add(item)
                        adapter.notifyDataSetChanged()
                    }
                }
            })
        }
        findViewById<Button>(R.id.btn_save).setOnClickListener {
            if (listTimes.isNotEmpty()) {
                saveToData()
            }
        }
        //getData()
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
        FirebaseHelper().getTimes(object : FirebaseHelper.OnGetTimesCallBack{
            override fun onSuccess(list: MutableList<TimeModel>) {
                Log.d("TAG", "Post getData: ${list.size}")
                listTimes.clear()
                listTimes.addAll(list)
                recyclerView.adapter = adapter
                noDataLayout.visibility = View.GONE
            }

            override fun onFailed() {
                //Show No Data
                noDataLayout.visibility = View.VISIBLE
            }
        })
    }
    private fun saveToData() {

        FirebaseHelper().saveTimeToFirestore(listTimes,object : FirebaseHelper.OnUploadCallBack{
            override fun onSuccess() {
                Toast.makeText(this@TimesActivity,"Upload Success", Toast.LENGTH_SHORT).show()
                finish()
            }

            override fun onFailed() {
                Toast.makeText(this@TimesActivity,"Upload Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onResume() {
        getData()
        super.onResume()
    }
}