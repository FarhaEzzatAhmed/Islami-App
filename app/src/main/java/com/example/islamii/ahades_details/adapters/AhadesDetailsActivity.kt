package com.example.islamii.ahades_details.adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.islamii.Constans
import com.example.islamii.R

class AhadesDetailsActivity : AppCompatActivity() {
    lateinit var hadesContentRecyclerView: RecyclerView
    lateinit var adapter: HadesContentAdapter
    lateinit var hadesNameTextView:TextView
    lateinit var backIcon:ImageView
    var hadesPosition :Int?= null
    var hadesName: String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ahades_details)
        hadesContentRecyclerView = findViewById(R.id.hades_content_recycler_view)
        adapter = HadesContentAdapter(null)
        hadesName = intent.getStringExtra(Constans.EXTRA_Hades_Name)
        hadesPosition = intent.getIntExtra(Constans.EXTRA_Hades_POSITION,-1)
        hadesContentRecyclerView.adapter = adapter
        readFileText()
        hadesNameTextView = findViewById(R.id.hades_details_name)
        hadesNameTextView.text =hadesName
        backIcon= findViewById(R.id.back)
        backIcon.setOnClickListener{
            finish()
        }

    }
    fun readFileText (){
        //.txt dh asm al extention ali feh fike al asset
        //val fileName ="ahdeth.txt"
        val fileName ="${"h"+hadesPosition?.plus(1)}.txt"
        //Io stream -> Input / output Stream ->Read from file/write
        val fileContent : String=   assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }
        // split de ht2smhom 3ala hasb al haga ali ana htaha gwaha w ana 3ayza a22smhom 3ala hasb al line l2n kol aya feh line
        val hadesContent = fileContent.split('\n')
        adapter.updateData(hadesContent)
    }

}