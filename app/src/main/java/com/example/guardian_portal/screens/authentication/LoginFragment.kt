package com.example.guardian_portal.screens.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.guardian_portal.R
import com.example.guardian_portal.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null
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
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {

            buttonContinue.setOnClickListener {
                loginUser()
            }

        }

    }

    private fun loginUser() {

        val email = binding?.editTextEmail?.text.toString()
        val password = binding?.editTextPassword?.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Login successful -> Navigate to next screen
                    findNavController().navigate(R.id.action_LoginFragment_to_homeFragment)
                } else {
                    // Login failed
                    Toast.makeText(requireContext(), "Login failed. Please try again.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun clearUI() {
        binding?.editTextEmail?.text?.clear()
        binding?.editTextPassword?.text?.clear()
    }

    override fun onResume() {
        super.onResume()
        clearUI()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}