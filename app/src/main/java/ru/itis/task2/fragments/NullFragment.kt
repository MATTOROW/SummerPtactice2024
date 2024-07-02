package ru.itis.task2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ru.itis.task2.R
import ru.itis.task2.databinding.FragmentNullBinding

class NullFragment : Fragment(R.layout.fragment_null) {
    private var binding: FragmentNullBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNullBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}