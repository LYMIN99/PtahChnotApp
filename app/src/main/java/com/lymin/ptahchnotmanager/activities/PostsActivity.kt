package com.lymin.ptahchnotmanager.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.adapter.PostListAdapter
import com.lymin.ptahchnotmanager.dialog.DialogPost
import com.lymin.ptahchnotmanager.firebaseHelper.FirebaseHelper
import com.lymin.ptahchnotmanager.model.PostModel

class PostsActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    lateinit var noDataLayout : LinearLayout
    val listPosts = mutableListOf<PostModel>()
    val adapter = PostListAdapter(listPosts,object : PostListAdapter.OnCallBack{
        override fun onEdit(itemOld: PostModel?, position: Int) {
            DialogPost(this@PostsActivity,itemOld,object : DialogPost.OnCallBack{
                @SuppressLint("NotifyDataSetChanged")
                override fun onConfirmClick(itemUpdate: PostModel?) {
                    if (itemUpdate != null) {
                        listPosts.remove(itemOld)
                        listPosts.add(position,itemUpdate)
                        recyclerView.adapter!!.notifyDataSetChanged()
                        //adapter.notifyDataSetChanged()
                    }
                }
            })
        }

        override fun onDelete(item: PostModel?, position: Int) {
            listPosts.remove(item)
        }
    })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        recyclerView = findViewById(R.id.recycler_view)
        noDataLayout = findViewById(R.id.ln_no_data)

        initToolBar()

        findViewById<ImageButton>(R.id.btn_add).setOnClickListener {
            DialogPost(this@PostsActivity,null,object : DialogPost.OnCallBack{
                @SuppressLint("NotifyDataSetChanged")
                override fun onConfirmClick(item: PostModel?) {
                    if (item != null) {
                        listPosts.add(item)
                        adapter.notifyDataSetChanged()
                    }
                }
            })
        }
        findViewById<Button>(R.id.btn_save).setOnClickListener {
            if (listPosts.isNotEmpty()) {
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
        FirebaseHelper().getPosts(object : FirebaseHelper.OnGetPostCallBack{
            override fun onSuccess(list: MutableList<PostModel>) {
                Log.d("TAG", "Post getData: ${list.size}")
                listPosts.clear()
                listPosts.addAll(list)
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

        FirebaseHelper().savePostToFirestore(listPosts,object : FirebaseHelper.OnUploadCallBack{
            override fun onSuccess() {
                Toast.makeText(this@PostsActivity,"Upload Success", Toast.LENGTH_SHORT).show()
                finish()
            }

            override fun onFailed() {
                Toast.makeText(this@PostsActivity,"Upload Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onResume() {
        getData()
        super.onResume()
    }
}