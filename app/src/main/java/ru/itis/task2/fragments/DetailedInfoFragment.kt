package ru.itis.task2.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import ru.itis.task2.R
import ru.itis.task2.dataClasses.Country
import ru.itis.task2.databinding.FragmentDetailedInfoBinding
import ru.itis.task2.repositories.CountryRepository

class DetailedInfoFragment : Fragment(R.layout.fragment_detailed_info) {
    private var binding: FragmentDetailedInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = requireActivity().getSharedPreferences("Default", Context.MODE_PRIVATE)

        val index = pref.getInt("ARG_INDEX", -1)

        val country: Country? = CountryRepository.countries.find {it.id == index}

        val requestOptions = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)
        binding = FragmentDetailedInfoBinding.bind(view)
        binding?.run {
            tvCountry.text = country?.name
            tvCountryCapital.text = country?.capital
            tvDescription.text = country?.description
            Glide.with(this.root)
                .load(country?.imageUrl)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.drawable.ic_home)
                .apply(requestOptions)
                .into(countryImage)
            btnGoBack.setOnClickListener {
                findNavController().navigate(R.id.action_detailedInfoFragment_to_infoFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}