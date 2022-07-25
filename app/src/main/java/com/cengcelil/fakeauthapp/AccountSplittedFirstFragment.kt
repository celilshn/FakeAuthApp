package com.cengcelil.fakeauthapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cengcelil.fakeauthapp.databinding.AccountSplittedFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountSplittedFirstFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var b: AccountSplittedFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = AccountSplittedFirstBinding.inflate(LayoutInflater.from(requireContext()))
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        return b.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b.btSubmit.setOnClickListener {
            findNavController().navigate(R.id.account_splitted_second)
        }

    }


}