package com.example.guardian_portal.screens.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guardian_portal.databinding.FragmentLoginBinding
import com.example.guardian_portal.databinding.FragmentWelcomeBinding

class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}