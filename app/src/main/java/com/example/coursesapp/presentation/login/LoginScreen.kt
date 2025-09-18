package com.example.coursesapp.presentation.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.coursesapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.coursesapp.databinding.LoginScreenBinding
import androidx.core.net.toUri
import com.example.coursesapp.presentation.bottomnavigation.BottomNavigation
import com.example.coursesapp.presentation.navigation.navigate

class LoginScreen() : Fragment(R.layout.login_screen) {

    private val viewModel by viewModel<LoginViewModel>()
    private var binding: LoginScreenBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = LoginScreenBinding.bind(view)

        setupListeners()
        setupValidation()
        socialMediaNavigation()
    }

    private fun socialMediaNavigation() {
        viewModel.urlString.observe(viewLifecycleOwner) { url ->
            val intent = Intent(Intent.ACTION_VIEW, url.toUri())
            startActivity(intent)
        }
    }

    private fun setupListeners() {
        binding?.btnLogin?.setOnClickListener {
            if (!isEmailValid()) {
                Toast.makeText(requireContext(), "Invalid email format", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            viewModel.login(binding?.etEmail?.text.toString(), binding?.etPassword?.text.toString())

            navigate(parentFragmentManager, BottomNavigation(), false)
        }

        binding?.btnVk?.setOnClickListener {
            viewModel.loginWithVk()
        }

        binding?.btnOk?.setOnClickListener {
            viewModel.loginWithOk()
        }

    }

    private fun setupValidation() {
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                updateLoginButtonState()
            }
        }

        binding?.etEmail?.addTextChangedListener(textWatcher)
        binding?.etPassword?.addTextChangedListener(textWatcher)

        binding?.btnLogin?.isEnabled = false
    }

    private fun updateLoginButtonState() {
        val email = binding?.etEmail?.text?.toString()?.trim()
        val password = binding?.etPassword?.text?.toString()?.trim()

        val isFormValid = !email.isNullOrEmpty() && !password.isNullOrEmpty()
        binding?.btnLogin?.isEnabled = isFormValid
    }

    private fun isEmailValid(): Boolean {
        val email = binding?.etEmail?.text.toString()
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
