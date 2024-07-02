package ru.itis.task2.fragments

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.animation.Animation
import ru.itis.task2.R
import ru.itis.task2.databinding.FragmentOutputTextBinding

class OutputTextFragment : Fragment(R.layout.fragment_output_text) {
    private var binding: FragmentOutputTextBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOutputTextBinding.bind(view)

        val text = arguments?.getString("ARG_TEXT") ?: "ERROR"

        binding?.run {
            outputText.text = text
            var animator = ObjectAnimator.ofInt(outputText, "textColor", Color.RED,
                Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.parseColor("#5c1461"),
                Color.parseColor("#AE0A31"))

            animator.setDuration(4500)
            animator.setEvaluator(ArgbEvaluator())

            animator.setRepeatCount(Animation.INFINITE)
            animator.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}