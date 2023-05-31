package com.example.capstoneproject.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.FragmentApplyBinding
import com.example.capstoneproject.databinding.FragmentProfileBinding

class ApplyFragment : Fragment() {
    private lateinit var binding: FragmentApplyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentApplyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnApply = binding.btnApply
        btnApply.setOnClickListener{
//            it.findNavController().navigate(R.id.UploadFragment)
        }
    }
}