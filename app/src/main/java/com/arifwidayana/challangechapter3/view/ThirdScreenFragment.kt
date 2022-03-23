package com.arifwidayana.challangechapter3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challangechapter3.R
import com.arifwidayana.challangechapter3.databinding.FragmentThirdScreenBinding
import com.arifwidayana.challangechapter3.model.PriceBookValue

class ThirdScreenFragment : Fragment() {
    private var bind: FragmentThirdScreenBinding? = null
    private val binding get() = bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        bind = FragmentThirdScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments?.getString(SecondScreenFragment.EXTRA_NAME)
        val value = arguments?.getParcelable<PriceBookValue>(FourthScreenFragment.VALUE)
        when {
            name != null -> {
                binding.tvResultCalculate.visibility = View.GONE
                binding.tvName.text = name
            }
            else -> {
                val bookValue = value?.equity.toString().toDouble() / value?.share.toString().toDouble()
                val result = value?.priceShare.toString().toDouble() / bookValue
                binding.tvName.visibility = View.GONE
                binding.btnToScreen4.visibility = View.GONE
                binding.tvResultCalculate.text = result.toString()
            }
        }

        binding.btnToScreen4.setOnClickListener{
            findNavController().navigate(R.id.action_thirdScreenFragment_to_fourthScreenFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind = null
    }
}