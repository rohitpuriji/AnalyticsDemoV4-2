package com.example.analyticsdemov4;

import java.util.HashMap;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import android.app.Application;

public class GoogleAnalyticsApp extends Application{

	private static final String PROPERTY_ID = "UA-58687359-3";

	public static int GENERAL_TRACKER = 0;
    
	//enumeration to choose type of tracker
	public enum TrackerName {
		APP_TRACKER, GLOBAL_TRACKER, ECOMMERCE_TRACKER,
	}

	public HashMap mTrackers = new HashMap();

	public GoogleAnalyticsApp(){
		super();
	}

	public synchronized Tracker getTracker(TrackerName appTracker){
		
		if (!mTrackers.containsKey(appTracker)) {
			GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
			Tracker t = (appTracker == TrackerName.APP_TRACKER) ? analytics.newTracker(PROPERTY_ID) : (appTracker == TrackerName.GLOBAL_TRACKER) ? analytics.newTracker(R.xml.global_tracker) : analytics.newTracker(R.xml.ecommerce_tracker);
			mTrackers.put(appTracker, t);
		}
		return (Tracker) mTrackers.get(appTracker);
	}

}
