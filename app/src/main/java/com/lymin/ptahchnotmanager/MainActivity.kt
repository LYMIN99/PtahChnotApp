package com.lymin.ptahchnotmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.lymin.ptahchnotmanager.R
import com.lymin.ptahchnotmanager.activities.PostsActivity
import com.lymin.ptahchnotmanager.adapter.ChnotAdapter
import com.lymin.ptahchnotmanager.firebaseHelper.FirebaseHelper
import com.lymin.ptahchnotmanager.model.ChnotModel
import com.lymin.ptahchnotmanager.model.PostModel
import java.util.Locale

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    private lateinit var toolbar: Toolbar
    lateinit var noDataLayout : LinearLayout
    private lateinit var drawer: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_drawer)

        recyclerView = findViewById(R.id.recycler_view)
        noDataLayout = findViewById(R.id.ln_no_data)

        initToolbar()
        initNavigationMenu()
        getData()
        findViewById<FloatingActionButton>(R.id.btn_add).setOnClickListener {
            startActivity(Intent(this@MainActivity,AddDataActivity::class.java))
        }

    }
    private fun initToolbar() {
        toolbar = findViewById(R.id.toolbar)
        toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
    }

    private fun initNavigationMenu() {
        val nav_view: NavigationView = findViewById(R.id.nav_view)
        drawer = findViewById(R.id.drawer_layout)
        val toggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
        }
        drawer.addDrawerListener(toggle)
        toggle.syncState()


        nav_view.findViewById<View>(R.id.ln_lottery).setOnClickListener {
          //  startActivity(Intent(this@MainActivity, DataSyncingTabsActivity::class.java))
            drawer.closeDrawers()
        }
        nav_view.findViewById<View>(R.id.ln_post).setOnClickListener {
            startActivity(Intent(this@MainActivity, PostsActivity::class.java))
            drawer.closeDrawers()
        }

        nav_view.findViewById<View>(R.id.ln_time).setOnClickListener {
         //   startActivity(Intent(this@MainActivity, DataSubmittingTabsActivity::class.java))
            drawer.closeDrawers()
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

    override fun onResume() {
        getData()
        super.onResume()
    }
}