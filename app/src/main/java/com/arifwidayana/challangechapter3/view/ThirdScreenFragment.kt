package com.arifwidayana.challangechapter3.view

import android.annotation.SuppressLint
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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Pass data with bundle
        //val name = arguments?.getString(SecondScreenFragment.EXTRA_NAME)

        val name = ThirdScreenFragmentArgs.fromBundle(arguments as Bundle).name
        val value = arguments?.getParcelable<PriceBookValue>(FourthScreenFragment.VALUE)
        when {
            name != null -> {
                binding.ivPbv.visibility = View.GONE
                binding.tvResultCalculate.visibility = View.GONE
                binding.tvEquity.visibility = View.GONE
                binding.tvShare.visibility = View.GONE
                binding.tvPriceShare.visibility = View.GONE
                binding.tvName.text = "Selamat datang $name"
            }
            else -> {
                val bookValue = value?.equity.toString().toDouble() / value?.share.toString().toDouble()
                val result = value?.priceShare.toString().toDouble() / bookValue
                binding.tvName.visibility = View.GONE
                binding.btnToScreen4.visibility = View.GONE
                binding.tvEquity.text = "Ekuitas Perusahaan = ${value?.equity}"
                binding.tvShare.text = "Lembar Saham Beredar = ${value?.share}"
                binding.tvPriceShare.text = "Harga Lembar Saham = ${value?.priceShare}"
                binding.tvResultCalculate.text = "Hasil Perhitungan PBV adalah $result`x "
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