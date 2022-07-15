package com.gb.m_2090_3.view.picture

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.*
import android.text.style.BulletSpan
import android.text.style.DynamicDrawableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.ImageSpan
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.gb.m_2090_3.R
import com.gb.m_2090_3.databinding.FragmentPictureBinding
import com.gb.m_2090_3.view.drawer.BottomNavigationDrawerFragment
import com.gb.m_2090_3.view.settings.SettingsFragment
import com.gb.m_2090_3.viewmodel.AppState
import com.gb.m_2090_3.viewmodel.PictureOfTheDayViewModel
import org.w3c.dom.Text


class PictureOfTheDayFragment : Fragment() {

    private var _binding: FragmentPictureBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPictureBinding.inflate(inflater, container, false)
        return binding.root

    }

    private val viewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLiveData().observe(viewLifecycleOwner) { appState ->
            renderData(appState)
        }
        viewModel.sendRequest()

        binding.chipToday.setOnClickListener {
            Toast.makeText(requireContext(), "chipToday", Toast.LENGTH_SHORT).show()
        }
        binding.chipYesterday.isEnabled = false
        binding.chipYesterday.setOnClickListener {
            Toast.makeText(requireContext(), "chipYesterday", Toast.LENGTH_SHORT).show()
        }

        binding.inputLayout.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://en.wikipedia.org/wiki/${binding.input.text.toString()}")
            })
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorite -> {}
            R.id.action_settings -> {
                requireActivity().supportFragmentManager.beginTransaction().hide(this)
                    .add(R.id.container, SettingsFragment.newInstance()).addToBackStack("").commit()
            }
            android.R.id.home -> {
                activity?.let {
                    BottomNavigationDrawerFragment().show(it.supportFragmentManager, "tag")
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }


    @SuppressLint("NewApi") // TODO HW не потерять пользователя 24-27 sdk версии
    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> {/*TODO HW*/
            }
            AppState.Loading -> {/*TODO HW*/
            }
            is AppState.Success -> {
                binding.imageView.load(appState.pictureOfTheDayResponseData.url) {
                    //TODO HW настроить загрузку изображения: error() placeholder()
                }


                binding.textView.text = appState.pictureOfTheDayResponseData.explanation
                binding.textView.typeface = Typeface.createFromAsset(requireActivity().assets,"folder1/folder3/az_Eret1.ttf")

                val spanned:Spanned
                val spannableString:SpannableString
                var spannableStringBuilder:SpannableStringBuilder


                val text = "My text \nbullet one \nbulleterter two\nbullet wetwwefrtweteone \nbullet wetwettwo\nbullet wetwetwone \nbullet two"
                spannableStringBuilder = SpannableStringBuilder(text)
                binding.textView.setText(spannableStringBuilder,TextView.BufferType.EDITABLE)
                spannableStringBuilder = binding.textView.text as SpannableStringBuilder


                val result = text.indexesOf("\n")

                var current = result.first()
                result.forEach {
                    if(current!=it){
                        spannableStringBuilder.setSpan(BulletSpan(20,ContextCompat.getColor(requireContext(),R.color.my_color),20),
                            current+1,it,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                    current = it
                }
                spannableStringBuilder.setSpan(BulletSpan(20,ContextCompat.getColor(requireContext(),R.color.my_color),20),
                    current+1,text.length,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

                Log.d("@@@",result.toString())


                for (i in text.indices){
                    if(text[i]=='t'){
                        spannableStringBuilder.setSpan(
                                ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.my_color)),
                                i,i+1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                }

                for (i in text.indices){
                    if(text[i]=='t'){
                        spannableStringBuilder.setSpan(
                            ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.my_color)),
                        i,i+1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                }

                val bitmap = ContextCompat.getDrawable(requireContext(), R.drawable.ic_earth)!!.toBitmap()
                for (i in text.indices){
                    if(text[i]=='o'){
                        spannableStringBuilder.setSpan(
                            ImageSpan(requireContext(),bitmap),
                        i,i+1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                }

                spannableStringBuilder.insert(3,"word")
                //spannableStringBuilder.replace(3,4,"word")





            }
        }
    }

    fun String.indexesOf(substr: String, ignoreCase: Boolean = true): List<Int> =
        (if (ignoreCase) Regex(substr, RegexOption.IGNORE_CASE) else Regex(substr))
            .findAll(this).map { it.range.first }.toList()


    companion object {
        fun newInstance() = PictureOfTheDayFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}