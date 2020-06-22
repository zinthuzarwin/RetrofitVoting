package com.ztzw.retrofitvoting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ztzw.retrofitvoting.R
import com.ztzw.retrofitvoting.model.QueenItem
import kotlinx.android.synthetic.main.king_item.view.*
import kotlinx.android.synthetic.main.queen_item.view.*


class QueenAdapter(var queenList: List<QueenItem>, context: Context) : RecyclerView.Adapter<QueenAdapter.QueenViewHolder>() {

    var mClickListener: ClickListener? = null

    val BASE_URL = " https://ucsmonywaonlinevote.000webhostapp.com/api/"

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
            itemView.kingID.text = queenItem.id
            Picasso.get()
                .load(queenItem.img_url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.queenImage)

            itemView.queenClassRoom.text = queenItem.classRoom
            itemView.queenName.text = queenItem.name
        }

        override fun onClick(v: View?) {
            mClickListener?.onClick(queen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueenViewHolder { //RecyclerView htae ko items htae tar

        var view = LayoutInflater.from(parent.context).inflate(R.layout.queen_item, parent, false)
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