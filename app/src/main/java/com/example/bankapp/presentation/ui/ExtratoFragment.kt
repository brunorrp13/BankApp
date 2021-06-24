package com.example.bankapp.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankapp.MainActivity
import com.example.bankapp.R
import com.example.bankapp.data.model.ExtratoItem
import com.example.bankapp.data.util.Resource
import com.example.bankapp.databinding.FragmentExtratoBinding
import com.example.bankapp.presentation.adapter.ExtratoAdapter
import com.example.bankapp.presentation.viewmodel.ViewModel
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.repository.local.SecurityPreferences

class ExtratoFragment : Fragment() {
    private lateinit var extratoFragmentBinding: FragmentExtratoBinding
    private lateinit var viewModel: ViewModel
    private lateinit var extratoAdapter: ExtratoAdapter
    private var isLoading = false

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
        viewModel = (activity as MainActivity).viewModel
        extratoAdapter = (activity as MainActivity).extratoAdapter

        setUserData()
        observe()
        getExtrato()
        initRecyclerView()
        viewExtratoitemList()
        onButtonClick()

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            // Refresh your fragment here
            getFragmentManager()?.beginTransaction()?.detach(this)?.attach(this)?.commit();
        }
    }

    private fun setUserData() {
        val user = viewModel.returnUserData()
        extratoFragmentBinding.helloUserTitle.text = user.nome
        extratoFragmentBinding.accountInfoMain.text = user.cpf
        extratoFragmentBinding.balanceAmountMain.text = user.saldo
    }

    private fun viewExtratoitemList() {
        viewModel.getExtrato()

        viewModel.extrato.observe(viewLifecycleOwner,{response->
            when(response){
                is Resource.Success ->{
                    hideProgressBar()
                    response.data?.let {
                        extratoAdapter.differ.submitList(it)
                    }
                }
                is Error->{
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(activity,"An error occurred : $it", Toast.LENGTH_LONG).show()
                    }
                }

                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun initRecyclerView() {
        extratoFragmentBinding.recyclerView.apply {
        adapter = extratoAdapter
            layoutManager = LinearLayoutManager(activity)
         }
    }

    private fun showProgressBar(){
        isLoading = true
        extratoFragmentBinding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        isLoading = false
        extratoFragmentBinding.progressBar.visibility = View.INVISIBLE
    }

    private fun getExtrato() {
        viewModel.getExtrato()
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