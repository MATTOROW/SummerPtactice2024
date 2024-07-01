package ru.itis.task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.itis.task2.databinding.FragmentInfoBinding
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