package com.lymin.ptahchnotmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import com.lymin.ptahchnotmanager.dialog.DialogPickDate
import com.lymin.ptahchnotmanager.dialog.DialogSelectPost
import com.lymin.ptahchnotmanager.dialog.DialogSelectTime
import com.lymin.ptahchnotmanager.firebaseHelper.FirebaseHelper
import com.lymin.ptahchnotmanager.model.ChnotDetailModel
import com.lymin.ptahchnotmanager.model.ChnotModel
import com.lymin.ptahchnotmanager.model.PostModel
import com.lymin.ptahchnotmanager.model.TimeModel

class AddDataActivity : AppCompatActivity() {
    lateinit var tvDate : TextView
    lateinit var tvTime : TextView
    val listTimes = mutableListOf<TimeModel>()
    val listPosts = mutableListOf<PostModel>()
    val listChnots = mutableListOf<ChnotDetailModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)

        initToolBar()
        initializeData()
        initClick()
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

        // Handle the back button click
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun initClick() {
        tvDate.setOnClickListener {
            DialogPickDate(this@AddDataActivity,object : DialogPickDate.OnCallBack{
                override fun onConfirmClick(value: String?) {
                    tvDate.text = value
                }
            })
        }

        tvTime.setOnClickListener {
            DialogSelectTime(this,tvTime.text.toString(),listTimes,object : DialogSelectTime.OnCallBack{
                override fun onConfirmClick(selectedItem: TimeModel?) {
                    if (selectedItem != null) {
                        tvTime.text = selectedItem.time
                    }
                }
            })
        }

        findViewById<Button>(R.id.btn_add_more).setOnClickListener {

        }

        findViewById<Button>(R.id.btn_save).setOnClickListener {
            if (validated()){
                saveToData()
            } else {
                Toast.makeText(this@AddDataActivity,"Please add all information first",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveToData() {

        var dataChnotModel = ChnotModel(tvDate.text.toString(),tvTime.text.toString(),listChnots)
    }

    private fun validated(): Boolean {
        if (tvDate.text.toString().isEmpty())
            return false
        if (tvTime.text.toString().isEmpty())
            return false
        if (listChnots.isEmpty())
            return false

        return  true

    }

    private fun initializeData() {
        tvDate = findViewById(R.id.tv_date)
        tvTime = findViewById(R.id.tv_time)

        FirebaseHelper().getTimes(object : FirebaseHelper.OnGetTimesCallBack{
            override fun onSuccess(list: MutableList<TimeModel>) {
                listTimes.addAll(list)
            }

            override fun onFailed() {
            }
        })

        FirebaseHelper().getPosts(object : FirebaseHelper.OnGetPostCallBack{
            override fun onSuccess(list: MutableList<PostModel>) {
                listPosts.addAll(list)
            }

            override fun onFailed() {
            }
        })
    }
}