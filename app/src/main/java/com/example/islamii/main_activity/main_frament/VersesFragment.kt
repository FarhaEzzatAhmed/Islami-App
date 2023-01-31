package com.example.islamii.main_activity.main_frament

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.islamii.Constans
import com.example.islamii.R
import com.example.islamii.ahades_details.adapters.AhadesDetailsActivity
import com.example.islamii.callbacks.OnHadedesClickListener
import com.example.islamii.data_model.ArAhades
import com.example.islamii.main_activity.main_frament.adapters.AhadesNameAdapter

class VersesFragment :Fragment(){

    lateinit var ahadesRecyclerView: RecyclerView
    lateinit var ahadesadapter : AhadesNameAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_verses,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ahadesRecyclerView = view.findViewById(R.id.ahhades_RcView)
        ahadesadapter = AhadesNameAdapter(ArAhades)
        ahadesRecyclerView.adapter = ahadesadapter
       //ahadesRecyclerView.layoutManager = LinearLayoutManager(context)
        ahadesadapter.onHadesClickListener = object : OnHadedesClickListener{
            override fun onHadesclick(position: Int ,hadesName:String) {
                val intent2 = Intent(requireActivity(),AhadesDetailsActivity ::class.java)
                intent2.putExtra(Constans.EXTRA_Hades_POSITION,position)
                intent2.putExtra(Constans.EXTRA_Hades_Name,hadesName)
                startActivity(intent2)
            }

        }
    }
}