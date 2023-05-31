package com.example.capstoneproject.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.capstoneproject.data.User
import com.example.capstoneproject.databinding.FragmentProfileBinding
import com.example.capstoneproject.ui.activity.FaqActivity
import com.example.capstoneproject.ui.activity.GuideActivity
import com.example.capstoneproject.ui.activity.LoginActivity
import com.example.capstoneproject.ui.activity.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
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
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lyLogout = binding.lyButton
        lyLogout.setOnClickListener{
            intentLogout()
        }

        user = FirebaseAuth.getInstance().currentUser!!
        userID = user.uid
        reference = FirebaseDatabase.getInstance("https://capstone-project-3480d-default-rtdb.firebaseio.com/")
            .getReference("Users")
            .child(userID)

        greeting = binding.username
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userGreeting = snapshot.getValue(User::class.java)

                if (userGreeting != null) {
                    name = userGreeting.name
                    greeting.text = "$name"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(activity, "Something went wrong", Toast.LENGTH_LONG).show()
            }
        })

        val lyPanduan = binding.lyPanduan
        lyPanduan.setOnClickListener{
            val i = Intent(requireContext(), GuideActivity::class.java)
            startActivity(i)
        }

//        val lyStatus = binding.lyStatus
//        lyStatus.setOnClickListener{
//            val i = Intent(requireContext(), EligibleFragment::class.java)
//            startActivity(i)
//        }

        val lyFaq = binding.lyFAQ
        lyFaq.setOnClickListener{
            val i = Intent(requireContext(), FaqActivity::class.java)
            startActivity(i)
        }
    }

    private fun intentLogout() {
        val intent = Intent(requireContext(), LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}