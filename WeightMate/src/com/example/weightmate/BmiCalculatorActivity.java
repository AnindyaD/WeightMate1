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

public class BmiCalculatorActivity extends ActionBarActivity {
	public final static String CALCULATE_BMI = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Get intent
		Intent intent = getIntent();
		setContentView(R.layout.activity_bmi_calculator);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bmi_calculator, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_bmi_calculator,
					container, false);
			return rootView;
		}
	}
	public void toBmiImperial (View view) {
		Intent intent = new Intent (this,BmiMetricCalculatorActivity.class );
		startActivity(intent);
	}
	
	public void toBmiCalculateImperial (View view) {
		
		double BMI= 0;
		
		EditText FeetInput = (EditText) findViewById(R.id.bmiCalcHeightTextFieldImperial1);
		double heightFt = Integer.parseInt(FeetInput.getText().toString());
		
		EditText InchesInput = (EditText) findViewById(R.id.bmiCalcHeightTextFieldImperial2);
		double heightInches = Integer.parseInt(InchesInput.getText().toString());
		
		EditText PoundsInput = (EditText) findViewById(R.id.bmiCalcWeightTextFieldImperial);
		double weightPounds = Integer.parseInt(PoundsInput.getText().toString());
		
		BMI = weightPounds / ((Math.sqrt(heightFt*12+heightInches))*703);
		
		String toSend = "" + Math.round(BMI);
		Intent intent = new Intent (this,BmiCalculatorResultsActivity.class );
		intent.putExtra(CALCULATE_BMI, toSend);
		
		startActivity(intent);
		
	}
	
	
}
