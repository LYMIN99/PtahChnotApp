package com.lymin.ptahchnotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.lymin.ptahchnotapp.activities.fragment.tinhnam.LotteryTinhnamFragment
import com.lymin.ptahchnotapp.activities.fragment.vnOld.LotteryVnOldFragment
import com.lymin.ptahchnotapp.databinding.ActivityMenuNewBinding

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    lateinit var noDataLayout : LinearLayout
    private lateinit var drawer: DrawerLayout
    lateinit var binding: ActivityMenuNewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_menu_new)

        initToolbar()
        getDataNew()
        initClick()

    }

    private fun initClick() {
        var btnLottery1 = findViewById<LinearLayout>(R.id.btn_lottery_1)
        var textLottery1 = findViewById<TextView>(R.id.btn_text_1)
        var btnLottery2 = findViewById<LinearLayout>(R.id.btn_lottery_2)
        var textLottery2 = findViewById<TextView>(R.id.btn_text_2)

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
}