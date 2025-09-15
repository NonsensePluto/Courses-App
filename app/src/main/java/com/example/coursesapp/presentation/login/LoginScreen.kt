package com.example.coursesapp.presentation.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.coursesapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.coursesapp.databinding.LoginScreenBinding
import androidx.core.net.toUri

class LoginScreen() : Fragment(R.layout.login_screen) {

    private val viewModel by viewModel<LoginViewModel>()

    private var binding: LoginScreenBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = LoginScreenBinding.bind(view)

        val email = binding?.etEmail?.text?.toString()?.trim()
        val password = binding?.etPassword?.text?.toString()?.trim()

        binding?.btnLogin?.isEnabled = !email.isNullOrEmpty() && !password.isNullOrEmpty()

        binding?.btnLogin?.setOnClickListener {
            viewModel.login(email.toString(), password.toString())

            Toast.makeText(requireContext(), "Login successful", Toast.LENGTH_SHORT).show()
        }

        binding?.btnVk?.setOnClickListener {
            viewModel.loginWithVk()
        }

        binding?.btnOk?.setOnClickListener {
            viewModel.loginWithOk()
        }

        viewModel.urlString.observe(viewLifecycleOwner) { url ->
            val intent = Intent(Intent.ACTION_VIEW, url.toUri())
            startActivity(intent)
        }
    }

}
