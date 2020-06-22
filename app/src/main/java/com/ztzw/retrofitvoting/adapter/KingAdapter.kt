package com.ztzw.retrofitvoting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ztzw.retrofitvoting.R
import com.ztzw.retrofitvoting.model.KingItem
import com.ztzw.retrofitvoting.model.QueenItem
import kotlinx.android.synthetic.main.king_item.view.*

class KingAdapter(var kingList: List<KingItem> = ArrayList()) : RecyclerView.Adapter<KingAdapter.KingViewHolder>() {

    var mClickListener: ClickListener? = null

    fun setClickListener(clickListener: ClickListener) {
        this.mClickListener = clickListener
    }


    inner class KingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private lateinit var king: KingItem

        init {
            itemView.setOnClickListener(this)
        }

        fun bindKing(kingItem: KingItem) {
            this.king = kingItem
            itemView.kingID.text = kingItem.id
            Picasso.get()
                .load(kingItem.img_url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.kingImage)

            itemView.kingClassRoom.text = kingItem.classRoom
            itemView.kingName.text = kingItem.name
        }

        override fun onClick(v: View?) {
            mClickListener?.onClick(king)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KingViewHolder { //RecyclerView htae ko items htae tar

        var view = LayoutInflater.from(parent.context).inflate(R.layout.king_item, parent, false)
        return KingViewHolder(view)

    }

    override fun getItemCount(): Int { //Recycler View htae ka items ko count tar..so Int type phit nay
        return  kingList.size
    }

    interface ClickListener {
        fun onClick(kingItem: KingItem)
    }

    override fun onBindViewHolder(holder: KingViewHolder, position: Int) {
        holder.bindKing(kingList[position])
    }


    fun updateResultList(resultList: List<KingItem>) {
        this.kingList = resultList
        notifyDataSetChanged()
    }
}