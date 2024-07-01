package ru.itis.task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.itis.task2.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding?.run {
            button.setOnClickListener {
                val text = inputText.text
                if (text.isNotEmpty()) {
                    val bundle = Bundle()
                    bundle.putString("ARG_TEXT", text.toString())
                    findNavController().navigate(R.id.action_mainFragment_to_outputTextFragment,
                        args = bundle)
                } else {
                    binding?.mainFragmentMain?.let { it1 -> Snackbar.make(it1, "Для отправки текста требуется заполнить поле!", Snackbar.LENGTH_LONG).show() }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}