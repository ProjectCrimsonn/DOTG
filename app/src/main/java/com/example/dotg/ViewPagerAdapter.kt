package com.example.dotg

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dotg.fragments.events_fragment
import com.example.dotg.fragments.news_fragment
import com.example.dotg.fragments.planned_fragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
      return 3
    }


    private val frags = arrayListOf(
        //this one stores the fragments you want  to be output in the viewpager in an array list
        news_fragment(),
        events_fragment(),
        planned_fragment()
    )

    override fun createFragment(position: Int): Fragment {
        return frags.get(index = position)
    }
}