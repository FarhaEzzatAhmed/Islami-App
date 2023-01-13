package com.example.islamii.main_activity.main_frament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.islamii.R

class TasbehFragment :Fragment(){
    //var textChange : Button?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_tasbeh,container,false)
        var changeCounter = 0
       var textChange = view.findViewById<Button>(R.id.counter_tasbeh)
        var btnclick = view.findViewById<Button>(R.id.sobhan_allah)
        btnclick.setOnClickListener{
            if (changeCounter <=32){
            changeCounter = changeCounter+1
            textChange.text = changeCounter.toString()
        }else{
                changeCounter =0
        }
        }

        return view
    }
}