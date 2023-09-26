package com.lymin.ptahchnotmanager

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.lymin.ptahchnotmanager.adapter.ChnotDetailAddAdapter
import com.lymin.ptahchnotmanager.dialog.DialogAddChnot
import com.lymin.ptahchnotmanager.dialog.DialogPickDate
import com.lymin.ptahchnotmanager.dialog.DialogSelectTime
import com.lymin.ptahchnotmanager.dialog.DialogUpdateChnot
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
    lateinit var recyclerView: RecyclerView

    val adapter = ChnotDetailAddAdapter(listChnots,object : ChnotDetailAddAdapter.OnCallBack{
        override fun onEdit(itemOld: ChnotDetailModel?, position: Int) {
            DialogUpdateChnot(this@AddDataActivity,listPosts,itemOld,object : DialogUpdateChnot.OnCallBack{
                @SuppressLint("NotifyDataSetChanged")
                override fun onConfirmClick(itemUpdate: ChnotDetailModel?) {
                    if (itemUpdate != null) {
                        listChnots.remove(itemOld)
                        listChnots.add(position,itemUpdate)
                        recyclerView.adapter!!.notifyDataSetChanged()
                        //adapter.notifyDataSetChanged()
                    }
                }
            })
        }

        override fun onDelete(item: ChnotDetailModel?, position: Int) {
            listChnots.remove(item)

            //recyclerView.adapter.notifyDataSetChanged()
        }
    })

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
            DialogAddChnot(this@AddDataActivity,listPosts,object : DialogAddChnot.OnCallBack{
                override fun onConfirmClick(item: ChnotDetailModel?) {
                    if (item != null) {
                        listChnots.add(item)
                        adapter.notifyDataSetChanged()
                    }
                }
            })
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

        val dataChnotModel = ChnotModel(tvDate.text.toString(),tvTime.text.toString(),listChnots)
        FirebaseHelper().saveToFirestore(dataChnotModel,object : FirebaseHelper.OnUploadCallBack{
            override fun onSuccess() {
                Toast.makeText(this@AddDataActivity,"Upload Success",Toast.LENGTH_SHORT).show()
                finish()
            }

            override fun onFailed() {
                Toast.makeText(this@AddDataActivity,"Upload Error",Toast.LENGTH_SHORT).show()
            }
        })
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

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter

    }
}