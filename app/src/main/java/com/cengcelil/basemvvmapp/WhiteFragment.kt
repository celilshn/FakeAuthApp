package com.cengcelil.basemvvmapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.cengcelil.basemvvmapp.databinding.WhiteFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WhiteFragment : Fragment() {

    private lateinit var viewModel: WhiteViewModel
    private lateinit var b: WhiteFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        b = WhiteFragmentBinding.inflate(LayoutInflater.from(requireContext()))
        viewModel = ViewModelProvider(this)[WhiteViewModel::class.java]
        return b.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}