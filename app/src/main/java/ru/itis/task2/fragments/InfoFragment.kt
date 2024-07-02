package ru.itis.task2.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import ru.itis.task2.R
import ru.itis.task2.adapters.CountryAdapter
import ru.itis.task2.databinding.FragmentInfoBinding
import ru.itis.task2.repositories.CountryRepository

class InfoFragment : Fragment(R.layout.fragment_info) {
    private var binding: FragmentInfoBinding? = null

    private var adapter: CountryAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        val pref = requireActivity().getSharedPreferences("Default", Context.MODE_PRIVATE)

        adapter = CountryAdapter(
            list = CountryRepository.countries,
            glide = Glide.with(this@InfoFragment),
            onClick = {
                findNavController().navigate(R.id.action_infoFragment_to_detailedInfoFragment)
            },
            pref = pref)
        binding?.run {
            itemsContainer.adapter = adapter
            itemsContainer.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}