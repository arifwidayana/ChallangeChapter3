package com.arifwidayana.challangechapter3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challangechapter3.R
import com.arifwidayana.challangechapter3.databinding.FragmentFirstScreenBinding

class FirstScreenFragment : Fragment() {
    private var bind: FragmentFirstScreenBinding? = null
    private val binding get() = bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        bind = FragmentFirstScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToScreen2.setOnClickListener{
            findNavController().navigate(R.id.action_firstScreenFragment_to_secondScreenFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind = null
    }
}