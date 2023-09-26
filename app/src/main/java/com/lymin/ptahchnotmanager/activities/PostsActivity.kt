package com.lymin.ptahchnotmanager.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.model.PostModel

class PostsActivity : AppCompatActivity() {
    val listPosts = mutableListOf<PostModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
    }
}