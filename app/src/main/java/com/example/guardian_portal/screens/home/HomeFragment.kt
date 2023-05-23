package com.example.guardian_portal.screens.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.guardian_portal.R
import com.example.guardian_portal.databinding.FragmentHomeBinding
import com.example.guardian_portal.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initializing Firebase Auth
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {

            textViewLogout.setOnClickListener {
                logOutUser()
            }

        }

    }

    private fun logOutUser() {

        // Log out and navigate to login screen
        auth.signOut()
        findNavController().popBackStack()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}