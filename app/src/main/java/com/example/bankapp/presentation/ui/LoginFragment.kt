package com.example.bankapp.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bankapp.R
import com.example.bankapp.databinding.LoginFragmentBinding
import com.example.tasks.view.validation.TextUtils
import java.util.regex.Matcher
import java.util.regex.Pattern


class LoginFragment : Fragment() {
    private lateinit var loginFragmentBinding: LoginFragmentBinding
//    private lateinit var viewModel: LoginViewModel
//    var user: User = SharedPrefManager.getInstance(requireActivity())?.user as User
//    var hasLoggedIn = SharedPrefManager.getInstance(requireActivity())?.hasLoggedIn!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginFragmentBinding  = LoginFragmentBinding.bind(view)
//        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

//        setLogin()
        validateAccess()
    }

//    private fun setLogin() {
//        if (hasLoggedIn) {
//            loginFragmentBinding.inputUser.setText(user.username)
//            loginFragmentBinding.inputPassword.setText(user.password)
//        }
//    }

    private fun validateAccess() {
        loginFragmentBinding.btnLogin.setOnClickListener {
        val username = loginFragmentBinding.inputUserName.text.toString().trim()
        val password = loginFragmentBinding.inputPassword.text.toString().trim()

        if (!(TextUtils.isValidCPF(username) || TextUtils.isValidEmail(username))){
          Toast.makeText(activity, "Preencha E-mail ou CPF válido", Toast.LENGTH_SHORT).show();
        } else if (!isValidPassword(password)) {
          Toast.makeText(activity, "A senha deve ter pelo menos uma letra maiuscula, um caracter especial e um caracter alfanumérico", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(activity, "OK", Toast.LENGTH_SHORT).show();
        }
     }
  }

    private fun isValidPassword(password: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher

        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+*!¨=])(?=\\S+$).{4,}$"

        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)

        return matcher.matches()
    }
}