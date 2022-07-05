package com.gb.m_2090_3.view.layouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import com.gb.m_2090_3.databinding.FragmentCoordinatorBinding
import com.gb.m_2090_3.view.layouts.behaviors.ButtonBehavior

class CoordinatorFragment : Fragment() {
    private var _binding: FragmentCoordinatorBinding? = null
    private val binding: FragmentCoordinatorBinding
        get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoordinatorBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    var flag = true
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (binding.fab.layoutParams as CoordinatorLayout.LayoutParams).behavior = ButtonBehavior(requireContext()) // 2 способ
    }
    companion object {
        @JvmStatic
        fun newInstance() = CoordinatorFragment()
    }
}
