package com.example.islamii.ahades_details.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamii.R

class HadesContentAdapter(var hadesLines: List<String?>?): Adapter<HadesContentAdapter.HdesContentViewHolder>(){





    class HdesContentViewHolder(val itemView :View):ViewHolder(itemView){

        val hadesLineText: TextView

        init {
            hadesLineText = itemView.findViewById(R.id.hades_line_text)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HdesContentViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_hades_line,parent,false)
         return HdesContentViewHolder(view)

    }

    override fun onBindViewHolder(holder: HdesContentViewHolder, position: Int) {
      holder.hadesLineText.text = hadesLines?.get(position)
    }

    override fun getItemCount(): Int {
         return hadesLines?.size ?:0
    }
fun updateData(hadesLines: List<String?>?){
    this.hadesLines = hadesLines
    notifyDataSetChanged()


}

}