package com.arifwidayana.challangechapter3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.arifwidayana.challangechapter3.databinding.FragmentSecondScreenBinding

class SecondScreenFragment : Fragment() {
    private var bind: FragmentSecondScreenBinding? = null
    private val binding get() = bind!!

    /*companion object {
        const val EXTRA_NAME = "NAME"
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        bind = FragmentSecondScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToScreen3.setOnClickListener{
            // Pass data with bundle
            /*val bundle = Bundle().apply {
                putString(EXTRA_NAME, binding.etName.text.toString())
            }
            findNavController().navigate(R.id.action_secondScreenFragment_to_thirdScreenFragment, bundle)*/

            if (binding.etName.text.isNullOrEmpty()) {
                Toast.makeText(context, "Please Input Your Name!", Toast.LENGTH_SHORT).show()
            } else {
                val action =
                    SecondScreenFragmentDirections.actionSecondScreenFragmentToThirdScreenFragment()
                action.name = binding.etName.text.toString()
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bind = null
    }
}