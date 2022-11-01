package com.arifwidayana.challangechapter3.ui

import androidx.navigation.fragment.findNavController
import com.arifwidayana.challangechapter3.R
import com.arifwidayana.challangechapter3.common.BaseFragment
import com.arifwidayana.challangechapter3.databinding.FragmentFirstScreenBinding

class FirstScreenFragment : BaseFragment<FragmentFirstScreenBinding>(
    FragmentFirstScreenBinding::inflate
) {
    override fun initView() {
        binding.btnToScreen2.setOnClickListener{
            findNavController().navigate(R.id.action_firstScreenFragment_to_secondScreenFragment)
        }
    }
}