package com.cengcelil.fakeauthapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.cengcelil.fakeauthapp.databinding.WhiteFragmentBinding
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
        b.btSubmit.setOnClickListener {
            startActivity(Intent(requireActivity(),MainActivity2::class.java))
            requireActivity().finish()

        }

    }


}