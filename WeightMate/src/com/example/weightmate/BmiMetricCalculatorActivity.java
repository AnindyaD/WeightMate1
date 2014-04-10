package com.example.weightmate;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.os.Build;

public class BmiMetricCalculatorActivity extends ActionBarActivity {
	public final static String CALCULATE_BMI = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bmi_metric_calculator);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bmi_imperial_calculator, menu);
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
			View rootView = inflater
					.inflate(R.layout.fragment_bmi_metric_calculator,
							container, false);
			return rootView;
		}
	}
	
	public void toBmiCalculateMetric (View view) {
		
		double BMI = 0;
		EditText KiloInput = (EditText) findViewById(R.id.bmiCalcWeightTextFieldMetric);
		double weightKilo = Integer.parseInt(KiloInput.getText().toString());
		
		EditText cmInput = (EditText) findViewById(R.id.bmiCalcHeightTextFieldMetric);
		double heightCm = Integer.parseInt(cmInput.getText().toString());
		
		BMI = weightKilo / ((heightCm/100)*(heightCm/100));

		String toSend = "" + Math.round(BMI);
		Intent intent = new Intent (this,BmiCalculatorResultsActivity.class );
		intent.putExtra(CALCULATE_BMI, toSend);
		
		startActivity(intent);
	}

}
