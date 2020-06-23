package com.ztzw.retrofitvoting.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ztzw.retrofitvoting.R
import com.ztzw.retrofitvoting.model.UserItem
import kotlinx.android.synthetic.main.queen_item.view.*


class QueenAdapter(var queenList: List<UserItem> = ArrayList()) : RecyclerView.Adapter<QueenAdapter.QueenViewHolder>() {

    var mClickListener: ClickListener? = null

    val BASE_URL = " https://ucsmonywaonlinevote.000webhostapp.com/api/"

    fun setClickListener(clickListener: ClickListener) {
        this.mClickListener = clickListener
    }

    inner class QueenViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private lateinit var queen: UserItem

        init {
            itemView.setOnClickListener(this)
        }

        fun bindPerson(queenItem: UserItem) {
            this.queen = queenItem
            itemView.queenID.text = queenItem.id
            Picasso.get()
                .load(queenItem.img_url)
                .placeholder(R.drawable.loading)
                .into(itemView.queenImage)

            itemView.queenClassRoom.text = queenItem.`class`
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
        fun onClick(queenItem: UserItem)
    }

    fun updateResultList(resultList: List<UserItem>) {
        this.queenList = resultList
        notifyDataSetChanged()
    }
}