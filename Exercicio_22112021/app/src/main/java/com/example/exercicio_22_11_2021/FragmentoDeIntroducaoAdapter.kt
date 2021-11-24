package com.example.exercicio_22_11_2021

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.lang.IllegalArgumentException

//Este é o adapter para o ViewPager de introdução ao app.
class FragmentoDeIntroducaoAdapter(fragmentManager:FragmentActivity, private val views: List<Fragment>): FragmentStateAdapter(fragmentManager) {
    override fun getItemCount(): Int {
        return views.size
    }

    override fun createFragment(position: Int): Fragment {
        return if (views.isEmpty()){
            throw IllegalArgumentException("The view list is empty")
        }
        else{
            views[position]
        }
    }
}