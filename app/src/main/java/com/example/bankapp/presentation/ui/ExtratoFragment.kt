package com.example.bankapp.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.bankapp.MainActivity
import com.example.bankapp.R
import com.example.bankapp.databinding.FragmentExtratoBinding
import com.example.bankapp.databinding.LoginFragmentBinding
import com.example.bankapp.presentation.viewmodel.LoginViewModel

class ExtratoFragment : Fragment() {
    private lateinit var extratoFragmentBinding: FragmentExtratoBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_extrato, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        extratoFragmentBinding = FragmentExtratoBinding.bind(view)
        viewModel = (activity as MainActivity).loginViewModel

        observe()
        onButtonClick()
    }

    private fun onButtonClick() {
        extratoFragmentBinding.btnLeave.setOnClickListener {
            findNavController().navigate(
                R.id.action_extratoFragment_to_loginFragment,
            )
        }
    }

    private fun observe() {
        viewModel.login.observe(viewLifecycleOwner, Observer {
            if (!it.success())
                Toast.makeText(context, it.failure(), Toast.LENGTH_SHORT).show()
        })
    }
}