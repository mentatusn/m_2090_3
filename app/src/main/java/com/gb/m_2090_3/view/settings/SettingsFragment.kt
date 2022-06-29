package com.gb.m_2090_3.view.settings

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.gb.m_2090_3.MainActivity
import com.gb.m_2090_3.R
import com.gb.m_2090_3.databinding.FragmentPictureBinding
import com.gb.m_2090_3.databinding.FragmentSettingsBinding
import com.gb.m_2090_3.view.drawer.BottomNavigationDrawerFragment
import com.gb.m_2090_3.viewmodel.AppState
import com.gb.m_2090_3.viewmodel.PictureOfTheDayViewModel


class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root

    }

    private val viewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }



    companion object {
        fun newInstance() = SettingsFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}