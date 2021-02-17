package com.cxrus.androidtrivia.controller.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.cxrus.androidtrivia.R
import com.cxrus.androidtrivia.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentGameOverBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_game_over, container, false)
        binding.tryAgainButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_gameOverFragment2_to_gameFragment)
        }
        
//        val args = Game
//        Toast.makeText(context, "NumCorrect : ${args.numCorrect}, NumQuestions : ${args.numQuestions}", Toast.LENGTH_SHORT).show()
        return binding.root
    }

}