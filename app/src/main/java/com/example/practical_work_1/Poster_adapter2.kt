package com.example.practical_work_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Poster_adapter2 (val con:Context, val list2:ArrayList<Poster2>):RecyclerView.Adapter<Poster_adapter2.Link>(){
    class Link(itemView: View):RecyclerView.ViewHolder(itemView) {
        val im_di:ImageView =  itemView.findViewById(R.id.item_img2)
        val title_di:TextView = itemView.findViewById(R.id.title2)
        val text_di:TextView = itemView.findViewById(R.id.text2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Link {
        val root = LayoutInflater.from(con).inflate(R.layout.item_2, parent, false)
        return Link(root)
    }

    override fun onBindViewHolder(holder: Link, position: Int) {
        holder.im_di.setImageResource(list2[position].imageId)
        holder.title_di.setText(list2[position].title)
        holder.text_di.setText(list2[position].text)
    }

    override fun getItemCount(): Int {
        return list2.size
    }


}