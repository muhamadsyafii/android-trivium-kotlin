package com.cxrus.androidtrivia.controller.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.cxrus.androidtrivia.R
import com.cxrus.androidtrivia.databinding.FragmentGameWinBinding

class GameWinFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentGameWinBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_game_win, container, false)
       /* binding.nextMatchButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_gameWinFragment_to_gameFragment2)
        }*/
        val args = GameWinFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context, "NumCorrect : ${args.numCorrect}, NumQuestions : ${args.numQuestions}", Toast.LENGTH_SHORT).show()

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)

        if (null == getShareIntent().resolveActivity(activity!!.packageManager)){
            menu.findItem(R.id.share).isVisible = false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }



    private fun getShareIntent() : Intent{
        val args = GameWinFragmentArgs.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
        return shareIntent
    }

    private fun shareSuccess(){
        startActivity(getShareIntent())
    }


}