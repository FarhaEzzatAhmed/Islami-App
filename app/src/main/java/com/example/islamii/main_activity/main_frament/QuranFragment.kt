package com.example.islamii.main_activity.main_frament

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.islamii.R
import com.example.islamii.callbacks.OnsouraClickListener
import com.example.islamii.data_model.ArSuras
import com.example.islamii.main_activity.main_frament.adapters.SurasNameAdapter
import com.example.islamii.quran_details.Quran_Details_activity

class QuranFragment :Fragment(){
    lateinit var quranRecyclerView: RecyclerView
    lateinit var quranAdapter : SurasNameAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranRecyclerView = view.findViewById(R.id.quran_recycler_view)
        quranAdapter = SurasNameAdapter(ArSuras)
        quranRecyclerView.adapter = quranAdapter
        quranRecyclerView.layoutManager =LinearLayoutManager(context)
        quranAdapter.onSuraClickListener = object : OnsouraClickListener{

            override fun onSuraClick(position: Int) {
                //val intent = Intent(this@QuranFragment,Quran_Details_activity::class.java)
            }
        }
    }

}