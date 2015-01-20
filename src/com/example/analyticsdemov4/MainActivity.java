package com.example.analyticsdemov4;

import android.app.Activity;
import android.os.Bundle;

import com.example.analyticsdemov4.GoogleAnalyticsApp.TrackerName;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Tracker t = ((GoogleAnalyticsApp)getApplication()).getTracker(TrackerName.APP_TRACKER);
		t.setScreenName("Main Activity");
		t.send(new HitBuilders.AppViewBuilder().build());
	

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		GoogleAnalytics.getInstance(MainActivity.this).reportActivityStart(this);
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		GoogleAnalytics.getInstance(MainActivity.this).reportActivityStop(this);
	}


}
