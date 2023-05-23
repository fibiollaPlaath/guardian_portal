package com.example.guardian_portal.screens.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.guardian_portal.R
import com.example.guardian_portal.databinding.FragmentAcademicRecordBinding
import com.example.guardian_portal.databinding.FragmentLoginBinding
import com.example.guardian_portal.models.Marks
import com.google.firebase.firestore.FirebaseFirestore

class AcademicRecordFragment : Fragment() {

    private var binding: FragmentAcademicRecordBinding? = null
    private lateinit var firestore: FirebaseFirestore
    private val marksRecyclerAdapter by lazy { getMarksRecyclerViewAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAcademicRecordBinding.inflate(layoutInflater, container, false)
        firestore = FirebaseFirestore.getInstance()
        binding?.recyclerViewMarks?.adapter = marksRecyclerAdapter
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        retrieveStudentMarks()
    }

    private fun retrieveStudentMarks() {

        // Retrieve marks collection data
        firestore.collection("marks")
            .get()

            .addOnSuccessListener { querySnapshot ->
                print(querySnapshot)
                // Handle successful data retrieval
                val markList = mutableListOf<Any>()

                for (document in querySnapshot) {
                    // Mapping document data to Marks model class
                    val marks = document.toObject(Marks::class.java)
                    markList.add(marks)

                    // Displaying information to UI
                    binding?.apply {
                        textViewStudentNumber.text = marks.studentnum.toString()
                        textViewName.text = marks.name
                        textViewYear.text = marks.AcademicYear.toString()

                        // TODO: Display marks
                      //  marksRecyclerAdapter.populateRecyclerAdapter()
                    }
                }


            }
            .addOnFailureListener { exception ->
                Toast.makeText(requireContext(), "$exception", Toast.LENGTH_SHORT).show()
            }
    }

    private fun getMarksRecyclerViewAdapter(): MarksRecyclerAdapter {

        return MarksRecyclerAdapter {
            binding?.apply {

            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}