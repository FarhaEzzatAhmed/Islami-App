package com.example.islamii.main_activity.main_frament.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamii.R
import com.example.islamii.callbacks.OnsouraClickListener
import com.example.islamii.data_model.SourasData

class SurasNameAdapter(var suras : List<String> , var count: Int =286) :

    RecyclerView.Adapter<SurasNameAdapter.SourasNameViewHolder>() {
    var onSuraClickListener :OnsouraClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourasNameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_quran,parent,false)

        return SourasNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: SourasNameViewHolder, position: Int) {
        holder.suraName.text = suras.get(position)
        holder.suraContentCount.text = "$count"
        holder.itemView.setOnClickListener{
            onSuraClickListener?.onSuraClick(position)
        }
    }

    override fun getItemCount(): Int {
      return  suras.size
    }
  class SourasNameViewHolder(val itemView :View) :ViewHolder(itemView){
 var suraName :TextView
 var  suraContentCount :TextView
      init {
          suraName = itemView.findViewById(R.id.sura_name)
          suraContentCount = itemView.findViewById(R.id.sura_number)
      }

  }


}