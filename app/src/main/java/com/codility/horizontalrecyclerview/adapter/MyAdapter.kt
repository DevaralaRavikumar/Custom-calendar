package com.codility.recyclerpicasso

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.codility.horizontalrecyclerview.R
import com.codility.horizontalrecyclerview.model.Version
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Created by Govind on 3/7/2018.
 */
class MyAdapter(private val versionList: ArrayList<Version>,context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var context:Context?=null
    private var clickedItemPosition: Int? = null
    init {
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(versionList[position])
    }

    override fun getItemCount(): Int {
        return versionList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
        fun bindItems(version: Version) {
            itemView.day_date.text = version.dayDate
            itemView.day_name.text = version.dayName
            if (clickedItemPosition == position) {
                itemView.day_name.setTextColor(context!!.getColor(R.color.colorWhite))
                itemView.day_date.setTextColor(context!!.getColor(R.color.colorWhite))
              itemView.item_layout.background=ContextCompat.getDrawable(context!!,R.drawable.layout_bg)
            } else {
                itemView.day_name.setTextColor(context!!.getColor(R.color.colorDarkBlue))
                itemView.day_date.setTextColor(context!!.getColor(R.color.colorDarkBlue))
                itemView.item_layout.setBackgroundColor(Color.TRANSPARENT)
            }
            if(version.ticketIndicator){
                itemView.ticket_indicator.visibility = View.VISIBLE
                if (clickedItemPosition == position) {
                    itemView.ticket_indicator.setBackgroundColor(context!!.getColor(R.color.colorWhite))
                }else {
                    itemView.ticket_indicator.setBackgroundColor(context!!.getColor(R.color.colorDarkBlue))
                }
            }else {
                itemView.ticket_indicator.visibility = View.INVISIBLE
            }
        }

        override fun onClick(p0: View?) {
            if (adapterPosition != -1) {
                clickedItemPosition = adapterPosition
               // versionList[adapterPosition].let { clickListener?.onAddressClick(it) }
                notifyDataSetChanged()
            }
        }
    }
}