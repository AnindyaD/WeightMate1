package com.example.weightmate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;

public class CalendarActivity extends ActionBarActivity {
	public final static String EXTRA_YEAR = "com.example.weightmate.YEAR";
	public final static String EXTRA_MONTH = "com.example.weightmate.MONTH";
	public final static String EXTRA_DAY = "com.example.weightmate.DAY";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_calendar);

		 CalendarView calendarView = (CalendarView)findViewById(R.id.calendarView1);
	     calendarView.setOnDateChangeListener(new OnDateChangeListener() {
	    	 
	    	 //Checks for date selected
	            public void onSelectedDayChange(CalendarView view, int year, int month,
	                    int dayOfMonth) {
	               sendDateInfo(year, month, dayOfMonth);
	            }
	        });
	}
	public void sendDateInfo(int year, int month, int dayOfMonth){ //Sends Date to DailyPlanner
		Intent intent = new Intent(this, DailyPlannerActivity.class);
		String yearStr, monthStr, dayStr;
		yearStr = "" + year;
		monthStr = "" + month;
		dayStr = "" + dayOfMonth;
		
		intent.putExtra(EXTRA_YEAR, yearStr);
		intent.putExtra(EXTRA_MONTH, monthStr);
		intent.putExtra(EXTRA_DAY, dayStr);
		startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_calendar,
					container, false);
			return rootView;
		}
	}

}
