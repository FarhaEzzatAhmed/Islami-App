package com.example.islamii.main_activity.main_frament

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamii.ApiManager.ApiManager
import com.example.islamii.ApiManager.Models.RadioChannel
import com.example.islamii.ApiManager.Models.RadioResponse
import com.example.islamii.R
import com.example.islamii.main_activity.main_frament.adapters.RadioAdapter
import com.example.islamii.player.PlayerService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadioFragment :Fragment(){
    val adapter= RadioAdapter()
    lateinit var recyclerView :RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radio,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.radio_rv)

        recyclerView.adapter = adapter
        adapter.onPlayClickListener = object :RadioAdapter.OnItemClickListener{
            override fun onItemClicked(position: Int, radioChannel: RadioChannel) {
                  startRadioService(radioChannel)
            }

        }

        adapter.onStopClickListener = object :RadioAdapter.OnItemClickListener{
            override fun onItemClicked(position: Int, radioChannel: RadioChannel) {
                stopPlayerService()
            }
        }
        getChannelsFromApi()

    }

    fun getChannelsFromApi(){
        ApiManager.getWepService().getRadioChannels().enqueue(object :Callback<RadioResponse>{
            override fun onResponse(call: Call<RadioResponse>, response: Response<RadioResponse>) {

                val channel = response.body()?.radios
                adapter.changeData(channel?: listOf())
            }

            override fun onFailure(call: Call<RadioResponse>, t: Throwable) {
                Toast.makeText(activity,t.localizedMessage?:"error",Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onStart(){
        super.onStart()
        startService()
        bindService()
    }
    fun startService(){
        val intent = Intent(requireActivity(),PlayerService::class.java)
        activity?.startService(intent)
    }

   override fun onStop(){
        super.onStop()
     activity?.unbindService(connection)
    }

    fun bindService(){
        val intent =Intent(activity,PlayerService::class.java)
        activity?.bindService(intent,connection,Context.BIND_AUTO_CREATE)
    }
    fun  startRadioService(item:RadioChannel){
        if (bound)
            service.startMediaPlayer(item.url!!,item.name!!)
    }

    fun stopPlayerService(){
        if (bound)
            service.pauseMediaPlayer()
    }

    lateinit var  service: PlayerService
    var bound = false

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, mBinder: IBinder?) {
            val binder = mBinder as PlayerService.MyBinder
            service = binder.getService()
            bound = true

        }

        override fun onServiceDisconnected(name: ComponentName?) {
             bound = false
        }


    }



}