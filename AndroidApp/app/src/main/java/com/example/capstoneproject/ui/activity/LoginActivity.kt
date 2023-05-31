package com.example.capstoneproject.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.core.content.ContextCompat.startActivity
import com.example.capstoneproject.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.newAccount.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }

        binding.buttonLogin.setOnClickListener {
            val email = binding.edEmail.text.toString()
            val password = binding.edtPass.text.toString()

            // validasi email
            if (email.isEmpty()) {
                binding.edEmail.error = "Email harus diisi!"
                binding.edEmail.requestFocus()
                return@setOnClickListener
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                // validasi email valid
                binding.edEmail.error = "Email tidak valid!"
                binding.edEmail.requestFocus()
                return@setOnClickListener
            } else if (password.isEmpty()) {
                // validasi password
                binding.edPassword.error = "Password harus diisi!"
                binding.edPassword.requestFocus()
                return@setOnClickListener
            } else {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                            intentMain()
                        } else {
                            Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }

    private fun intentMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}