package com.example.islamii.main_activity.main_frament.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamii.R
import com.example.islamii.callbacks.OnHadedesClickListener
import com.example.islamii.data_model.AhadesDataItem

class AhadesNameAdapter(var hades:List<String>) : Adapter<AhadesNameAdapter.AhadesNamesViewHolder>() {


    class AhadesNamesViewHolder(val itemView: View):ViewHolder(itemView){
        var hadesName:TextView
        init {
          hadesName = itemView.findViewById(R.id.hades_name)
       }

    }
    var onHadesClickListener:OnHadedesClickListener?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AhadesNamesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.ahades_item,parent,false)
        return AhadesNamesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AhadesNamesViewHolder, position: Int) {
        holder.hadesName.text = hades.get(position)
        holder.itemView.setOnClickListener{
            onHadesClickListener?.onHadesclick(position,hades.get(position))
        }
    }

    override fun getItemCount(): Int {
     return hades.size
    }
}