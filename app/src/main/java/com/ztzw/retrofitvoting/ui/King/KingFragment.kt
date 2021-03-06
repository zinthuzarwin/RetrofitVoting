package com.ztzw.retrofitvoting.ui.King

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ztzw.retrofitvoting.R
import com.ztzw.retrofitvoting.adapter.KingAdapter
import com.ztzw.retrofitvoting.model.UserItem
import kotlinx.android.synthetic.main.fragment_king.*

class KingFragment : Fragment(), KingAdapter.ClickListener {

    private lateinit var kingViewModel: KingViewModel
    private lateinit var kingAdapter: KingAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
      return inflater.inflate(R.layout.fragment_king,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        kingAdapter = KingAdapter()
        kingAdapter.setClickListener(this)
        recyclerViewKing.apply {
            adapter = kingAdapter
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        }
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        kingViewModel.loadKingModel()
    }

    private fun observeViewModel() {
        kingViewModel = ViewModelProvider(this)
            .get(KingViewModel::class.java)


        kingViewModel.kingList.observe(viewLifecycleOwner,
            Observer { myResult ->
                kingAdapter.updateResultList(myResult)
            })
    }

    override fun onClick(kingItem: UserItem) {

        Toast.makeText(context, "${kingItem.name}", Toast.LENGTH_LONG).show()
        var king = kingItem
        var action = KingFragmentDirections.actionNavHomeToVoteFragment(king)
        findNavController().navigate(action)
    }
}