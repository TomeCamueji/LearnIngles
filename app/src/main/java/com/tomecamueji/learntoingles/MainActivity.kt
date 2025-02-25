package com.tomecamueji.learntoingles

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewpager.widget.ViewPager
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import com.tomecamueji.learntoingles.fragment.BichosFragment
import com.tomecamueji.learntoingles.fragment.NumberFragment
import com.tomecamueji.learntoingles.fragment.VogaisFragment

class MainActivity : AppCompatActivity() {
    private lateinit var smartTabLayout: SmartTabLayout
    private lateinit var viewPager: ViewPager

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        smartTabLayout = findViewById(R.id.viewpagertab)
        viewPager = findViewById(R.id.viewpager)


        //configurar adapter para  abas
        val Adapter = FragmentPagerItemAdapter(
            supportFragmentManager,
            FragmentPagerItems.with(this)
                .add("Bichos", BichosFragment::class.java)
                .add("Números", NumberFragment::class.java)
                .add("Vogais", VogaisFragment::class.java)
                .create()
        )

        viewPager.adapter = Adapter
        smartTabLayout.setViewPager(viewPager)

    }




}