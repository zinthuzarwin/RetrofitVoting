package com.ztzw.retrofitvoting.ui.Queen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ztzw.retrofitvoting.R

class QueenFragment : Fragment() {

    private lateinit var queenViewModel: QueenViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        queenViewModel =
                ViewModelProviders.of(this).get(QueenViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_queen, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        queenViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}