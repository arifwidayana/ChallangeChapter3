package com.arifwidayana.challangechapter3.ui

import android.annotation.SuppressLint
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.arifwidayana.challangechapter3.common.BaseFragment
import com.arifwidayana.challangechapter3.databinding.FragmentThirdScreenBinding
import com.arifwidayana.challangechapter3.model.PriceBookValue
import com.arifwidayana.challangechapter3.utils.Constant
import com.arifwidayana.challangechapter3.utils.currency

class ThirdScreenFragment : BaseFragment<FragmentThirdScreenBinding>(
    FragmentThirdScreenBinding::inflate
) {
    private val args by navArgs<ThirdScreenFragmentArgs>()

    override fun initView() {
        onView()
        onClick()
    }

    @SuppressLint("SetTextI18n")
    private fun onView() {
        val value = arguments?.getParcelable<PriceBookValue>(Constant.VALUE)
        binding.apply {
            when (value) {
                null -> {
                    visible()
                }
                else -> {
                    val bookValue = value.equity.toString().toDouble() / value.share.toString().toDouble()
                    val result = value.priceShare.toString().toDouble() / bookValue
                    btnToScreen4.visibility = View.GONE
                    tvName.text = "Hai, ${value.name} inilah Nilai PBV Perusahaan kamu"
                    tvEquity.text = "Ekuitas Perusahaan = ${currency(value.equity.toString())}"
                    tvShare.text = "Lembar Saham Beredar = ${currency(value.share.toString())}"
                    tvPriceShare.text = "Harga Lembar Saham = ${currency(value.priceShare.toString())}"
                    tvResultCalculate.text = "Hasil Perhitungan PBV adalah ${currency(result.toString())}x "
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun visible() {
        binding.apply {
            ivPbv.visibility = View.GONE
            tvResultCalculate.visibility = View.GONE
            tvEquity.visibility = View.GONE
            tvShare.visibility = View.GONE
            tvPriceShare.visibility = View.GONE
            tvName.text = "Selamat datang ${args.name}"
        }
    }

    private fun onClick() {
        binding.btnToScreen4.setOnClickListener {
            findNavController().navigate(
                ThirdScreenFragmentDirections.actionThirdScreenFragmentToFourthScreenFragment(args.name)
            )
        }
    }
}