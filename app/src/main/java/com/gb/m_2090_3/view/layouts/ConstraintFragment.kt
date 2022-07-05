package com.gb.m_2090_3.view.layouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gb.m_2090_3.databinding.FragmentConstraintBinding

class ConstraintFragment : Fragment() {
    private var _binding: FragmentConstraintBinding? = null
    private val binding: FragmentConstraintBinding
        get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConstraintBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    var flag = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn3.setOnClickListener {
            flag = !flag
            binding.group1.visibility = if (flag) View.VISIBLE else View.INVISIBLE

        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = ConstraintFragment()
    }
}
