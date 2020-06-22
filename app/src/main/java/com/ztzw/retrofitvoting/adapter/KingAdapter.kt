package com.ztzw.retrofitvoting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ztzw.retrofitvoting.R
import com.ztzw.retrofitvoting.model.KingItem

class KingAdapter(var kingList: List<KingItem>, context: Context) : RecyclerView.Adapter<KingAdapter.KingViewHolder>() {

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
//            itemView.txtClass.text = voting.classRoom
//            itemView.txtName.text = voting.name
//            itemView.profile_image.setImageResource(person.profileImage)
        }

        override fun onClick(v: View?) {
            mClickListener?.onClick(king)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KingViewHolder { //RecyclerView htae ko items htae tar

        var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_king, parent, false)
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
}