package com.arifwidayana.challangechapter3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challangechapter3.R
import com.arifwidayana.challangechapter3.databinding.FragmentFourthScreenBinding
import com.arifwidayana.challangechapter3.model.PriceBookValue

class FourthScreenFragment : Fragment() {
    private var bind: FragmentFourthScreenBinding? = null
    private val binding get() = bind!!

    companion object {
        const val VALUE = "VALUE"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        bind = FragmentFourthScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBackScreen3.setOnClickListener{
            val equity = binding.etEquityValue.text.toString().toDouble()
            val share = binding.etSheetPerShare.text.toString().toDouble()
            val price = binding.etPricePerShare.text.toString().toDouble()
            val calculate = PriceBookValue(equity,share,price)
            val parcel = Bundle().apply {
                putParcelable(VALUE, calculate)
            }
            findNavController().navigate(R.id.action_fourthScreenFragment_to_thirdScreenFragment, parcel)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind = null
    }
}