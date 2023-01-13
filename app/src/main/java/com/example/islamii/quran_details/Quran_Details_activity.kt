package com.example.islamii.quran_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.islamii.Constans
import com.example.islamii.R
import com.example.islamii.quran_details.adapters.SuraContentAdapter

class Quran_Details_activity : AppCompatActivity() {
    var suraPosition :Int?=null
    var suraName : String?= null
    lateinit var suraContentRecyclerView: RecyclerView
    lateinit var adapter :SuraContentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran_details)
        suraContentRecyclerView = findViewById(R.id.sura_content_recycler_view)
        adapter = SuraContentAdapter(null)

        suraName = intent.getStringExtra(Constans.EXTRA_SURA_Name)
        suraPosition = intent.getIntExtra(Constans.EXTRA_SURA_POSITION,-1)
        suraContentRecyclerView.adapter =adapter
        readFileText()
    }

    // 3lshan a3ml read l file asset
    fun readFileText (){
        //.txt dh asm al extention ali feh fike al asset
        val fileName ="${suraPosition?.plus(1)}.txt"
        //Io stream -> Input / output Stream ->Read from file/write
        val fileContent : String=   assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }
        // split de ht2smhom 3ala hasb al haga ali ana htaha gwaha w ana 3ayza a22smhom 3ala hasb al line l2n kol aya feh line
       val suraContent = fileContent.split('\n')
        adapter.updateData(suraContent)
    }

}