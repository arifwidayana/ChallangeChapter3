package com.arifwidayana.challangechapter3.ui

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.arifwidayana.challangechapter3.R
import com.arifwidayana.challangechapter3.common.BaseFragment
import com.arifwidayana.challangechapter3.databinding.FragmentFourthScreenBinding
import com.arifwidayana.challangechapter3.model.PriceBookValue
import com.arifwidayana.challangechapter3.utils.Constant

class FourthScreenFragment : BaseFragment<FragmentFourthScreenBinding>(
    FragmentFourthScreenBinding::inflate
) {
    private val args by navArgs<FourthScreenFragmentArgs>()

    override fun initView() {
        onClick()
    }

    private fun onClick() {
        binding.apply {
            btnBackScreen3.setOnClickListener{
                when {
                    etEquityValue.text.isNullOrEmpty() -> showMessage(true, getString(R.string.input_equity))
                    etSheetPerShare.text.isNullOrEmpty() -> showMessage(true, getString(R.string.input_share))
                    etPricePerShare.text.isNullOrEmpty() -> showMessage(true, getString(R.string.input_price))
                    else -> {
                        val equity = etEquityValue.text.toString().toDouble()
                        val share = etSheetPerShare.text.toString().toDouble()
                        val price = etPricePerShare.text.toString().toDouble()
                        val calculate = PriceBookValue(args.name, equity, share, price)
                        findNavController().navigate(
                            R.id.action_fourthScreenFragment_to_thirdScreenFragment,
                            Bundle().apply { putParcelable(Constant.VALUE, calculate) }
                        )
                    }
                }
            }
        }
    }
}