package com.example.islamii.main_activity.main_frament.adapters

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamii.ApiManager.Models.RadioChannel
import com.example.islamii.R

class RadioAdapter():RecyclerView.Adapter<RadioAdapter.ViewHolder> (){

  var chnnels = listOf<RadioChannel?>()
    var onPlayClickListener:OnItemClickListener?=null
    var onStopClickListener:OnItemClickListener?=null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view =LayoutInflater.from(parent.context).inflate(R.layout.radio_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.title.text = chnnels[position]?.name
        if(onPlayClickListener != null){
            onPlayClickListener?.onItemClicked(position, chnnels[position]!!)
        }

        if(onStopClickListener != null){
            onStopClickListener?.onItemClicked(position, chnnels[position]!!)
        }
    }
    fun changeData(data:List<RadioChannel?>){
        this.chnnels=data
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
      return  chnnels.size
    }


    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        lateinit var title: TextView
        lateinit var play:ImageView
        lateinit var stop:ImageView

        init {
            title = itemView.findViewById(R.id.channel_name)
            play  = itemView.findViewById(R.id.play)
            stop  = itemView.findViewById(R.id.stop_ic)

        }

    }

    interface OnItemClickListener{
        fun onItemClicked(position: Int,radioChannel: RadioChannel)
    }
}