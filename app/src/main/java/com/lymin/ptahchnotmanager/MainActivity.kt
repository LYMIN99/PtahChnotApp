package com.lymin.ptahchnotmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.lymin.ptahchnotmanager.activities.LotteryActivity
import com.lymin.ptahchnotmanager.activities.PostsActivity
import com.lymin.ptahchnotmanager.activities.TimesActivity
import com.lymin.ptahchnotmanager.activities.fragment.tinhnam.LotteryTinhnamFragment
import com.lymin.ptahchnotmanager.activities.fragment.vnOld.LotteryVnOldFragment

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    lateinit var noDataLayout : LinearLayout
    private lateinit var drawer: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_drawer)
        noDataLayout = findViewById(R.id.ln_no_data)

        initToolbar()
        initNavigationMenu()
     //   getData()
        getDataNew()

        initClick()

    }

    private fun initClick() {
        var btnLottery1 = findViewById<LinearLayout>(R.id.btn_lottery_1)
        var textLottery1 = findViewById<TextView>(R.id.btn_text_1)
        var btnLottery2 = findViewById<LinearLayout>(R.id.btn_lottery_2)
        var textLottery2 = findViewById<TextView>(R.id.btn_text_2)

        // Initialize the FrameLayout and FragmentManager
        val frameLayout = findViewById<FrameLayout>(R.id.framelayout)
        val fragmentManager = supportFragmentManager

// Create instances of your fragments
        val lottery1Fragment = LotteryVnOldFragment()
        val lottery2Fragment = LotteryTinhnamFragment()

        //First
        // Replace the FrameLayout content with Lottery1Fragment
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.framelayout, lottery1Fragment)
        transaction.commit()

        btnLottery1.setOnClickListener {
            btnLottery1.background.setTint(resources.getColor(R.color.orange_800))
            btnLottery2.background.setTint(resources.getColor(R.color.primary))

            // Replace the FrameLayout content with Lottery1Fragment
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.framelayout, lottery1Fragment)
            transaction.commit()
        }

        btnLottery2.setOnClickListener {
            btnLottery2.background.setTint(resources.getColor(R.color.orange_800))
            btnLottery1.background.setTint(resources.getColor(R.color.primary))

            // Replace the FrameLayout content with Lottery2Fragment
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.framelayout, lottery2Fragment)
            transaction.commit()
        }


        findViewById<FloatingActionButton>(R.id.btn_add).setOnClickListener {
            startActivity(Intent(this@MainActivity,AddDataActivity::class.java))
        }

    }

    private fun getDataNew() {

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
            startActivity(Intent(this@MainActivity, LotteryActivity::class.java))
            drawer.closeDrawers()
        }
        nav_view.findViewById<View>(R.id.ln_post).setOnClickListener {
            startActivity(Intent(this@MainActivity, PostsActivity::class.java))
            drawer.closeDrawers()
        }

        nav_view.findViewById<View>(R.id.ln_time).setOnClickListener {
            startActivity(Intent(this@MainActivity, TimesActivity::class.java))
            drawer.closeDrawers()
        }
    }

//    private fun getData() {
//       FirebaseHelper.getDataYesterday(object  : FirebaseHelper.OnGetDataallBack{
//            override fun onSuccess(list: MutableList<ChnotModel>) {
//                Log.d("TAG", "getData: ${list.size}")
//                val adapter = ChnotAdapter(list)
//                recyclerView.adapter = adapter
//                noDataLayout.visibility = View.GONE
//            }
//
//            override fun onFailed() {
//                //Show No Data
//                noDataLayout.visibility = View.VISIBLE
//            }
//        })
//
//    }
//
//    override fun onResume() {
//        getData()
//        super.onResume()
//    }
}