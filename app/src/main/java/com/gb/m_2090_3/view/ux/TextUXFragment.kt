package com.gb.m_2090_3.view.ux

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gb.m_2090_3.databinding.FragmentUxTextBinding

class TextUXFragment : Fragment() {
    private var _binding: FragmentUxTextBinding? = null
    private val binding: FragmentUxTextBinding
        get() = _binding!!

    companion object{
        fun newInstance() = TextUXFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUxTextBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}