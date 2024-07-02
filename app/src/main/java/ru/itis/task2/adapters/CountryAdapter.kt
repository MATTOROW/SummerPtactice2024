package ru.itis.task2.adapters

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.task2.dataClasses.Country
import ru.itis.task2.databinding.ItemCountryBinding
import ru.itis.task2.holders.CountryHolder

class CountryAdapter(
    private val list: List<Country>,
    private val glide: RequestManager,
    private val onClick: (Country) -> Unit,
    private val pref: SharedPreferences): RecyclerView.Adapter<CountryHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryHolder = CountryHolder(
        ItemCountryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
        pref = pref
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.onBind(list[position])
    }

}