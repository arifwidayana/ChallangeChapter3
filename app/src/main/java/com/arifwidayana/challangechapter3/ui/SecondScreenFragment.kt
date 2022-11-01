package com.arifwidayana.challangechapter3.ui

import androidx.navigation.fragment.findNavController
import com.arifwidayana.challangechapter3.R
import com.arifwidayana.challangechapter3.common.BaseFragment
import com.arifwidayana.challangechapter3.databinding.FragmentSecondScreenBinding

class SecondScreenFragment : BaseFragment<FragmentSecondScreenBinding>(
    FragmentSecondScreenBinding::inflate
) {

    override fun initView() {
        onClick()
    }

    private fun onClick() {
        binding.btnToScreen3.setOnClickListener {
            fieldValidation()
        }
    }

    private fun fieldValidation() {
        binding.apply {
            when {
                etName.text.isNullOrEmpty() -> {
                    showMessage(true, getString(R.string.field_input_name))
                }
                else -> {
                    findNavController().navigate(
                        SecondScreenFragmentDirections
                            .actionSecondScreenFragmentToThirdScreenFragment()
                            .setName(etName.text.toString())
                    )
                }
            }
        }
    }
}