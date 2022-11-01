package com.arifwidayana.challangechapter3.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.arifwidayana.challangechapter3.databinding.FragmentThirdScreenBinding
import com.arifwidayana.challangechapter3.model.PriceBookValue

class ThirdScreenFragment : Fragment() {
    private var bind: FragmentThirdScreenBinding? = null
    private val binding get() = bind!!

    private val args by navArgs<ThirdScreenFragmentArgs>()

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

        val value = arguments?.getParcelable<PriceBookValue>(FourthScreenFragment.VALUE)

        with(binding){
            when (value) {
                null -> {
                    ivPbv.visibility = View.GONE
                    tvResultCalculate.visibility = View.GONE
                    tvEquity.visibility = View.GONE
                    tvShare.visibility = View.GONE
                    tvPriceShare.visibility = View.GONE
                    tvName.text = "Selamat datang ${args.name}"
                }
                else -> {
                    val bookValue = value.equity.toString().toDouble() / value.share.toString().toDouble()
                    val result = value.priceShare.toString().toDouble() / bookValue
                    btnToScreen4.visibility = View.GONE
                    tvName.text = "Hai, ${value.name} inilah Nilai PBV Perusahaan kamu"
                    tvEquity.text = "Ekuitas Perusahaan = ${value.equity}"
                    tvShare.text = "Lembar Saham Beredar = ${value.share}"
                    tvPriceShare.text = "Harga Lembar Saham = ${value.priceShare}"
                    tvResultCalculate.text = "Hasil Perhitungan PBV adalah ${result}x "
                }
            }
        }

        binding.btnToScreen4.setOnClickListener{
            //findNavController().navigate(R.id.action_thirdScreenFragment_to_fourthScreenFragment)
            findNavController().navigate(ThirdScreenFragmentDirections.actionThirdScreenFragmentToFourthScreenFragment(
                args.name
            ))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind = null
    }
}