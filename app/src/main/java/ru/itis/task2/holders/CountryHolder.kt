package ru.itis.task2.holders

import android.content.Context
import android.content.SharedPreferences
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import ru.itis.task2.R
import ru.itis.task2.dataClasses.Country
import ru.itis.task2.databinding.ItemCountryBinding

class CountryHolder(
    private var binding: ItemCountryBinding,
    private val glide: RequestManager,
    private val onClick: (Country) -> Unit,
    private val pref: SharedPreferences
): ViewHolder(binding.root) {

    private val requestOptions = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)

    private val context: Context
        get() = itemView.context

    fun onBind(country: Country) {
        binding.run {
            tvCountry.text = country.name
            tvCountryCapital.text = country.capital

            glide.load(country.imageUrl)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.drawable.ic_home)
                .apply(requestOptions)
                .into(countryImage)

            root.setOnClickListener {
                pref.edit().putInt("ARG_INDEX", country.id).apply()
                onClick.invoke(country)
            }
        }
    }
}