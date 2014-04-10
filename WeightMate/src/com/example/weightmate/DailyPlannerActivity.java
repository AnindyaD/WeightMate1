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
import android.widget.TextView;

public class DailyPlannerActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_daily_planner);
		
		Intent intent = getIntent();
		TextView yearView = (TextView) findViewById(R.id.textView1);
		TextView monthView = (TextView) findViewById(R.id.textView2);
		TextView dayView = (TextView) findViewById(R.id.textView3);
		yearView.setText(intent.getStringExtra(CalendarActivity.EXTRA_YEAR));
		monthView.setText(intent.getStringExtra(CalendarActivity.EXTRA_MONTH));
		dayView.setText(intent.getStringExtra(CalendarActivity.EXTRA_DAY));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.daily_planner, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_daily_planner,
					container, false);
			return rootView;
		}
	}

}
