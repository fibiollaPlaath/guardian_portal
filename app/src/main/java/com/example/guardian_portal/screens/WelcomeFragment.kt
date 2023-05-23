package com.example.guardian_portal.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.guardian_portal.R
import com.example.guardian_portal.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private var binding: FragmentWelcomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(layoutInflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigating to next screen
        binding?.buttonContinue?.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_LoginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}