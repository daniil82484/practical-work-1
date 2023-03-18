package com.example.practical_work_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.practical_work_1.R


class ImageViewPagerAdapter : RecyclerView.Adapter<ImageViewPagerAdapter.ViewHolder>() {

    private val imagesList = arrayListOf(
        R.drawable.f1, R.drawable.f2, R.drawable.f3,
        R.drawable.f21, R.drawable.f22
    )

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.viewpage_item,parent,false))
    }

    override fun getItemCount(): Int = imagesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.findViewById<AppCompatImageView>(R.id.imageView).let {
            it.setImageDrawable(ContextCompat.getDrawable(it.context,imagesList[position]))
        }
        holder.view.findViewById<AppCompatTextView>(R.id.pageNumber).text = "$position"
    }
}
