package com.example.islamii.player

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViews.RemoteView
import androidx.core.app.NotificationCompat
import com.example.islamii.MyApplication.Companion.RADIO_PLAAYER_NOTIFICATION_CHANNEL
import com.example.islamii.R

class PlayerService:Service() {

    var mediaPlayer = MediaPlayer()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val urlToPlay = intent?.getStringExtra("url")
        val name = intent?.getStringExtra("name")
        val action = intent?.getStringExtra("action")

        if (urlToPlay != null && name != null)
            startMediaPlayer(urlToPlay, name)
        if (action != null) {
            Log.e("action", action)
            if (action.equals(PLAY_ACTION)){
                playPauseMediaPlayer()
        } else if (action.equals(STOP_ACTION)) {
            stopMediaPlayer()

        }
    }
        return  START_NOT_STICKY
    }

    var name:String = ""

    private fun playPauseMediaPlayer(){
        Log.e("action","play pause")
        if (mediaPlayer.isPlaying){
            mediaPlayer.pause()
        }else if(!mediaPlayer.isPlaying){
            mediaPlayer.start()

        }
        updateNotification()
    }
    val RADIO_PLAYER_NOTIFICATIO_ID =20
    private fun updateNotification() {
        val defultView = RemoteViews(packageName, R.layout.notification_defult_view)
        defultView.setTextViewText(R.id.title,"Islami App Radio")
        defultView.setTextViewText(R.id.desc,name)

        defultView.setImageViewResource(
            R.id.play,if (mediaPlayer.isPlaying) R.drawable.ic_stop else R.drawable.ic_play
        )

        defultView.setOnClickPendingIntent(R.id.play,getPlayButtonPendingIntent())
        defultView.setOnClickPendingIntent(R.id.stop,getStopButtonPendingIntent())

        var builder = NotificationCompat.Builder(this,RADIO_PLAAYER_NOTIFICATION_CHANNEL)
            .setSmallIcon(R.drawable.notification)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomContentView(defultView)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setDefaults(0)
            .setSound(null)

        val notificationManager:NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(RADIO_PLAYER_NOTIFICATIO_ID,builder.build())
    }
    val PLAY_ACTION ="play"
    val STOP_ACTION ="stop"

   private fun getPlayButtonPendingIntent():PendingIntent {
        val intent = Intent(this,PlayerService::class.java)
         intent.putExtra("action",PLAY_ACTION)

       val pendingIntent = PendingIntent.getService(
        this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

         return pendingIntent
    }
   private fun getStopButtonPendingIntent():PendingIntent {
       val intent = Intent(this, PlayerService::class.java)
       intent.putExtra("action", STOP_ACTION)

       val pendingIntent = PendingIntent.getService(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

       return pendingIntent
   }

    fun startMediaPlayer(urlToPlay: String?, name: String?) {

       pauseMediaPlayer()
        //
        if (name != null) {
            this.name = name
        }
        mediaPlayer =MediaPlayer()
        mediaPlayer.setDataSource(this, Uri.parse(urlToPlay))
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener {
            it.start()
        }
        createNotificationForMediaPlayer(name)
    }

    private fun createNotificationForMediaPlayer(name: String?) {
        val defultView = RemoteViews(packageName,R.layout.notification_defult_view)
        defultView.setTextViewText(R.id.title,"Islami App Radio")
        defultView.setTextViewText(R.id.desc,name)
        defultView.setImageViewResource(R.id.play,if(mediaPlayer.isPlaying)R.drawable.ic_stop else R.drawable.ic_play)
        defultView.setOnClickPendingIntent(R.id.play,getPlayButtonPendingIntent())
        defultView.setOnClickPendingIntent(R.id.stop,getStopButtonPendingIntent())

        var builder = NotificationCompat.Builder(this,RADIO_PLAAYER_NOTIFICATION_CHANNEL)
            .setSmallIcon(R.drawable.notification)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setCustomContentView(defultView)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setSound(null)

        startForeground(RADIO_PLAYER_NOTIFICATIO_ID,builder.build())

    }

 fun pauseMediaPlayer() {
        if (mediaPlayer.isPlaying){
            mediaPlayer.pause()
        }

    }

    private fun stopMediaPlayer(){
        if (mediaPlayer.isPlaying){
            mediaPlayer.stop()
            mediaPlayer.reset()
        }
        stopForeground(true)
        stopSelf()
    }
    val binder=MyBinder()
    override fun onBind(intent: Intent?): IBinder? {
        return binder

    }

    inner class MyBinder:Binder(){
        public fun getService():PlayerService{
            return this@PlayerService
        }

    }
}