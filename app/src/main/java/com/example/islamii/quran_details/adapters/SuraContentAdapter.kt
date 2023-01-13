package com.example.islamii.quran_details.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamii.R

class SuraContentAdapter (var suraLines :List<String?>?): Adapter<SuraContentAdapter.SuraContentViewHolder>() {



    class SuraContentViewHolder(val itemView: View):ViewHolder(itemView){
       val suraLineText : TextView
       init {

           suraLineText = itemView.findViewById(R.id.sura_item_line_text)

       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraContentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_sura_line,parent,false)

        return SuraContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuraContentViewHolder, position: Int) {
        holder.suraLineText.text = suraLines?.get(position)
    }

    override fun getItemCount(): Int {
        return suraLines?.size?:0
    }


    // 3lshan y3ml refresh ll data
    fun  updateData(suraLines: List<String?>?){
        this.suraLines = suraLines
        notifyDataSetChanged()
    }



}