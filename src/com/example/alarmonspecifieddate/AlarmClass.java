package com.example.alarmonspecifieddate;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@SuppressLint("NewApi")
public class AlarmClass extends BroadcastReceiver 
{

	//private static final int NID = 0;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onReceive(Context context, Intent arg1)
	{
		// TODO Auto-generated method stub
		
		Toast.makeText(context, "Time is Over", Toast.LENGTH_LONG).show();	
		
		/**------------------**/
		NotificationManager notificationManager 
		  = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		  Notification.Builder builder = new Notification.Builder(context);
		  
		  Intent intent = new Intent(context, AlarmClass.class);
		  PendingIntent pendingIntent  = PendingIntent.getActivity(context, 0, intent, 0);
		 
		  
		  builder
		  .setSmallIcon(R.drawable.ic_launcher)
		  .setContentTitle("Alarm")
		  .setContentText("Wake Up!!!")
		  .setContentInfo("ContentInfo")
		  .setTicker("Alarm")
		  .setLights(0xFFFF0000, 500, 500) //setLights (int argb, int onMs, int offMs)
		  .setContentIntent(pendingIntent)
		  .setAutoCancel(true);
		  
		  Notification notification = builder.getNotification();
		  
		  notificationManager.notify(R.drawable.ic_launcher, notification);

}

}