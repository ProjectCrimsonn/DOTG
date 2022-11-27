package com.example.dotg.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.dotg.databinding.FragmentEventsFragmentBinding
import com.example.dotg.planned

class events_fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEventsFragmentBinding.inflate(layoutInflater, container, false)
        binding.plansBtn.setOnClickListener {
            val intent = Intent(activity,planned::class.java)
            startActivity(intent)
        }
        return binding.root
    }



}