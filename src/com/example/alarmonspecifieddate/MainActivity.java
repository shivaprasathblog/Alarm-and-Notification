package com.example.alarmonspecifieddate;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity
{
	DatePicker dp;
	TimePicker tp;
	Button setalarm;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dp=(DatePicker)findViewById(R.id.datePicker1);
		tp=(TimePicker)findViewById(R.id.timePicker1);
		//Making time picker with 12 hrs format
		tp.setIs24HourView(false);
		setalarm=(Button)findViewById(R.id.button1);
		
		//Getting the Current instance of Calendar
		Calendar now= Calendar.getInstance();
		
		/**Initializing the Current Date and Time from the system date and time **/
		//dp.init(year, monthOfYear, dayOfMonth, onDateChangedListener)
		dp.init(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH),null);
		tp.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
		tp.setCurrentMinute(now.get(Calendar.MINUTE));
		
		setalarm.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
				
				//Getting Current time and date from Date Picker and TimePicker
				Calendar currenttimeanddate=Calendar.getInstance();
				
				Calendar setalarmon=Calendar.getInstance();
				
				//setalarmon.set(year, month, day, hourOfDay, minute, second)
				setalarmon.set(dp.getYear(), dp.getMonth(), dp.getDayOfMonth(),tp.getCurrentHour(), tp.getCurrentMinute(),00);
				
				if (setalarmon.compareTo(currenttimeanddate)<=0)
				{
					Toast.makeText(MainActivity.this,"Invalid Date ,Already Passed", Toast.LENGTH_LONG).show();
				}
				
				else 
				{
					setAlarm(setalarmon);
				}
			}
		});
		
		
		
	}

	protected void setAlarm(Calendar setalarmon)
	{
		// TODO Auto-generated method stub
		
		Intent i = new Intent(MainActivity.this,AlarmClass.class);
		
		//PendingIntent pi = PendingIntent.getBroadcast(context, requestCode, intent, flags)
		PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, 123, i, 0);
		
		AlarmManager am= (AlarmManager)getSystemService(ALARM_SERVICE);
		
		//am.set(type, triggerAtMillis, operation)
		am.set(AlarmManager.RTC_WAKEUP, setalarmon.getTimeInMillis(), pi);
		
		Toast.makeText(MainActivity.this,"Alarm is Set on "+setalarmon.getTime(), Toast.LENGTH_LONG).show();
		
		
	}


}
