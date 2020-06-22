package com.ztzw.retrofitvoting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ztzw.retrofitvoting.R
import com.ztzw.retrofitvoting.model.QueenItem


class QueenAdapter(var queenList: List<QueenItem>, context: Context) : RecyclerView.Adapter<QueenAdapter.QueenViewHolder>() {

    var mClickListener: ClickListener? = null

    fun setClickListener(clickListener: ClickListener) {
        this.mClickListener = clickListener
    }

    inner class QueenViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private lateinit var queen: QueenItem

        init {
            itemView.setOnClickListener(this)
        }

        fun bindPerson(queenItem: QueenItem) {
            this.queen = queenItem
//            itemView.txtClass.text = voting.classRoom
//            itemView.txtName.text = voting.name
            //itemView.profile_image.setImageResource(person.profileImage)
        }

        override fun onClick(v: View?) {
            mClickListener?.onClick(queen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueenViewHolder { //RecyclerView htae ko items htae tar

        var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_queen, parent, false)
        return QueenViewHolder(view)

    }

    override fun getItemCount(): Int { //Recycler View htae ka items ko count tar..so Int type phit nay
        return  queenList.size
    }

    override fun onBindViewHolder(holder: QueenViewHolder, position: Int) {
        holder.bindPerson(queenList[position])
    }

    interface ClickListener {
        fun onClick(queenItem: QueenItem)
    }

}