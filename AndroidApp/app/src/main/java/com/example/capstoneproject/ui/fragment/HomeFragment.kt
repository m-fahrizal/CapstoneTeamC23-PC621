package com.example.capstoneproject.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.capstoneproject.data.User
import com.example.capstoneproject.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var greeting: TextView
    private lateinit var user: FirebaseUser
    private lateinit var reference: DatabaseReference
    private lateinit var userID: String
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        user = FirebaseAuth.getInstance().currentUser!!
        userID = user.uid
        reference = FirebaseDatabase.getInstance("https://capstone-project-3480d-default-rtdb.firebaseio.com/")
            .getReference("Users")
            .child(userID)

        greeting = binding.greetings
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userGreeting = snapshot.getValue(User::class.java)

                if (userGreeting != null) {
                    name = userGreeting.name
                    greeting.text = "Hi, $name"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity, "Something went wrong", Toast.LENGTH_LONG).show()
            }
        })

        var g = 0
        val exProsedur = binding.exProsedur
        exProsedur.parentLayout.setOnClickListener {
            if (g == 0) {
                g = 1
                exProsedur.expand()
            } else {
                g = 0
                exProsedur.collapse()
            }
        }

        val exSyarat = binding.exSyarat
        exSyarat.parentLayout.setOnClickListener {
            if (g == 0) {
                g = 1
                exSyarat.expand()
            } else {
                g = 0
                exSyarat.collapse()
            }
        }

        val exKeunggulan = binding.exKeunggulan
        exKeunggulan.parentLayout.setOnClickListener {
            if (g == 0) {
                g = 1
                exKeunggulan.expand()
            } else {
                g = 0
                exKeunggulan.collapse()
            }
        }
    }
}