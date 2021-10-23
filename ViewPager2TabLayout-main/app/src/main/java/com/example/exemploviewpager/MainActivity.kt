package com.example.exemploviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


private const val NUM_PAGES = 3

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager2
    lateinit var fragmentAdapter: PagerAdapter

    lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)
        fragmentAdapter = PagerAdapter(this)
        viewPager.adapter = fragmentAdapter

        viewPager.setPageTransformer(ZoomOutPageTransformer())  //PagerTransformer

        tabs = findViewById(R.id.tabs)
        TabLayoutMediator(tabs,viewPager){tab, position ->
            if (position == 0) {
                tab.text = "Titulo 1"
            }
            else if (position == 1) {
                tab.text = "Titulo 2"
            }
            else {
                tab.text = "Titulo 3"
            }
        }.attach()

    }


    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    inner class PagerAdapter(fragmentActivity: FragmentActivity)
        :FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            return NUM_PAGES
        }

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> Fragment01()
                1 -> Fragment02()
                else -> Fragment03()
            }
        }

    }
}