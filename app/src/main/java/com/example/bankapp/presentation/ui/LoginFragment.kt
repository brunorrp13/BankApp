package com.example.bankapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.bankapp.MainActivity
import com.example.bankapp.R
import com.example.bankapp.databinding.LoginFragmentBinding
import com.example.bankapp.presentation.viewmodel.ViewModel
import com.example.tasks.view.validation.TextUtils


class LoginFragment : Fragment() {
    private lateinit var loginFragmentBinding: LoginFragmentBinding
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginFragmentBinding  = LoginFragmentBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel

        setLogin()
        validateAccess()
    }

    private fun setLogin() {
        val user = viewModel.getLogin()
        loginFragmentBinding.inputUserName.setText(user.username)
        loginFragmentBinding.inputPassword.setText(user.password)
        }


     private fun validateAccess() {
        loginFragmentBinding.btnLogin.setOnClickListener {
        val username = loginFragmentBinding.inputUserName.text.toString().trim()
        val password = loginFragmentBinding.inputPassword.text.toString().trim()

        if (!(TextUtils.isValidCPF(username) || TextUtils.isValidEmail(username))){
          Toast.makeText(activity, "Preencha E-mail ou CPF válido", Toast.LENGTH_SHORT).show();
        } else if (!TextUtils.isValidPassword(password)) {
          Toast.makeText(activity, "A senha deve ter pelo menos uma letra maiuscula, um caracter especial e um caracter alfanumérico", Toast.LENGTH_SHORT).show();
        } else {
            viewModel.doLogin(username, password)

            viewModel.login.observe(viewLifecycleOwner, Observer {
                if (it.success()) {
                    findNavController().navigate(
                        R.id.action_loginFragment_to_extratoFragment
                    )
                } else {
                    Toast.makeText(context, it.failure(), Toast.LENGTH_SHORT).show()
                }
           })

        }
     }
  }


}