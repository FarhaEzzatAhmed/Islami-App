package com.example.islamii.main_activity.main_frament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islamii.Constans
import com.example.islamii.R

class TasbehFragment :Fragment(){
    lateinit var image: ImageView
    lateinit var phase: TextView
    lateinit var counterTv :TextView
    var counter: Int =0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeh,container,false)









        //var view:View = inflater.inflate(R.layout.fragment_tasbeh,container,false)
        //var changeCounter = 0
        //var textChange = view.findViewById<Button>(R.id.counter)
        //var btnclick = view.findViewById<Button>(R.id.sobhan_allah)
        //btnclick.setOnClickListener{
            //if (changeCounter <=32){
            //changeCounter = changeCounter+1
            //textChange.text = changeCounter.toString()
        //}else{
          //      changeCounter =0
        //}
        //}

       // return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.sebha_body_image)
        counterTv = view.findViewById(R.id.counter)
        counterTv.text ="$counter"
        phase = view.findViewById(R.id.phase)
        image.setOnClickListener{

            onSebhaClicked()
        }

    }

    private fun onSebhaClicked() {
        image.rotation = image.rotation + 5
        counter++
        counterTv.text="$counter"

if (phase.text == Constans.KHTEMA){
    phase.text == Constans.SUBHAN_ALLAH
    counter = 0
    counterTv.text = "$counter"
}

        if (counter==33) {
            if (phase.text == Constans.SUBHAN_ALLAH) {
                phase.text = Constans.ALHAMDULALLAH
                counter = 0
                counterTv.text = "$counter"
            }
            else if (phase.text == Constans.ALHAMDULALLAH){
                counter =0
                phase.text = Constans.ALLAH_AKBAR
            }
            else if (phase.text == Constans.ALLAH_AKBAR)
                phase.text = Constans.KHTEMA
                counter = 0
                counterTv.text = "$counter"
        }
    }
}