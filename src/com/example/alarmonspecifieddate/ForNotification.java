package com.example.alarmonspecifieddate;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ForNotification extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_for_notification);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.for_notification, menu);
		return true;
	}

}
