package com.arifwidayana.challangechapter3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.arifwidayana.challangechapter3.R
import com.arifwidayana.challangechapter3.databinding.FragmentFourthScreenBinding
import com.arifwidayana.challangechapter3.model.PriceBookValue

class FourthScreenFragment : Fragment() {
    private var bind: FragmentFourthScreenBinding? = null
    private val binding get() = bind!!
    private val args by navArgs<FourthScreenFragmentArgs>()

    companion object {
        const val VALUE = "VALUE"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        bind = FragmentFourthScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnBackScreen3.setOnClickListener{
                when {
                    etEquityValue.text.isNullOrEmpty() -> Toast.makeText(context, "Please Input Equity!", Toast.LENGTH_SHORT).show()
                    etSheetPerShare.text.isNullOrEmpty() -> Toast.makeText(context, "Please Input Share!", Toast.LENGTH_SHORT).show()
                    etPricePerShare.text.isNullOrEmpty() -> Toast.makeText(context, "Please Input Price Share!", Toast.LENGTH_SHORT).show()
                    else -> {
                        val equity = etEquityValue.text.toString().toDouble()
                        val share = etSheetPerShare.text.toString().toDouble()
                        val price = etPricePerShare.text.toString().toDouble()
                        val calculate = PriceBookValue(args.name, equity, share, price)
                        val parcel = Bundle().apply {
                            putParcelable(VALUE, calculate)
                        }
                        findNavController().navigate(R.id.action_fourthScreenFragment_to_thirdScreenFragment, parcel)
                    }
                }
            }
        }

        // with autocomplete point Currency
        /*binding.etEquityValue.addTextChangedListener(object: TextWatcher {
            var setEdit = binding.etEquityValue.text.toString().trim()

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                when {
                    p0.toString() != setEdit -> {
                        binding.etEquityValue.removeTextChangedListener(this)
                        val rep = p0.toString().replace("[Rp.]".toRegex(),"")
                        when {
                            rep.isNotEmpty() -> setEdit = formatCurrency(rep.toDouble())
                        }
                        binding.etEquityValue.setText(setEdit)
                        binding.etEquityValue.setSelection(setEdit.length)
                        binding.etEquityValue.addTextChangedListener(this)
                    }
                    else -> setEdit = ""
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind = null
    }

    // with autocomplete point Currency
    /*private fun formatCurrency(number: Double): String {
        val formatRupiah = NumberFormat.getCurrencyInstance(Locale("IN", "ID"))
        val split = formatRupiah.format(number).split(" ".toRegex())
        val len = split[0].length
        return "${split[0].substring(0, 2)}.${split[0].substring(2, len)}"
    }*/
}